package org.tabbleman.oesm.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tabbleman.oesm.entity.Exam;
import org.tabbleman.oesm.entity.ExamRecord;
import org.tabbleman.oesm.entity.Question;
import org.tabbleman.oesm.entity.User;
import org.tabbleman.oesm.repository.ExamRecordRepository;
import org.tabbleman.oesm.repository.ExamRepository;
import org.tabbleman.oesm.repository.QuestionRepository;
import org.tabbleman.oesm.repository.UserRepository;
import org.tabbleman.oesm.service.ExamService;
import org.tabbleman.oesm.utils.dto.ExamConfigDto;
import org.tabbleman.oesm.utils.dto.MetaQuestionAnswer;
import org.tabbleman.oesm.utils.dto.QuestionAnswerSheetDto;
import org.tabbleman.oesm.utils.qo.UserExamsQo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamRepository examRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    ExamRecordRepository examRecordRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Exam> getUserFinishedExams(UserExamsQo userExamsQo) {
        List<ExamRecord> allExamRecords = examRecordRepository.findAllByUserId(userExamsQo.getUserId());
        List<Exam> exams = new ArrayList<>();
        for (ExamRecord er : allExamRecords) {
            if (er.getExamStatus() == 0) {
                continue;
            }
            Exam ex = examRepository.findExamByExamId(er.getExamId());
            exams.add(ex);
        }
        return exams;
    }

    @Override
    public List<Exam> getUserAllExams(UserExamsQo userExamsQo) {
        List<ExamRecord> allExamRecords = examRecordRepository.findAllByUserId(userExamsQo.getUserId());
        List<Exam> exams = new ArrayList<>();
        for (ExamRecord er : allExamRecords) {
            Exam ex = examRepository.findExamByExamId(er.getExamId());
            exams.add(ex);
        }
        return exams;
    }

    @Override
    public List<Exam> getUserUnfinishedExams(UserExamsQo userExamsQo) {
        List<ExamRecord> allExamRecords = examRecordRepository.findAllByUserId(userExamsQo.getUserId());
        List<Exam> exams = new ArrayList<>();
        for (ExamRecord er : allExamRecords) {
            if (er.getExamStatus() == 1) {
                continue;
            }
            Exam ex = examRepository.findExamByExamId(er.getExamId());
            log.info(ex.toString());
            exams.add(ex);
        }
        return exams;
    }

    /**
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * api for user
     * todo filter finished exam and unfinished exam.
     *
     * @param userExamsQo
     * @return
     */
    @Override
    public List<Long> getUserExamsId(UserExamsQo userExamsQo) {
        List<ExamRecord> examRecords = new ArrayList<>();

        List<Long> examIds = new ArrayList<>();
        try {
            Long userId = userExamsQo.getUserId();
            examRecords = examRecordRepository.findAllByUserId(userExamsQo.getUserId());
            examIds = examRecords.stream()
                    .map(ExamRecord::getExamId)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }


        return examIds;
    }

    @Override
    public List<Question> generateQuestionsByExamId(Long examId) {
        List<Question> questions = new ArrayList<>();
        Exam exam = examRepository.findExamByExamId(examId);
        try {
            questions = questionRepository.generateQuestions(exam.getExamQuestionCount());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

    /**
     * this function is for single exam detail view in front end
     *
     * @param examId
     * @return
     */
    @Override
    public Exam getExamByExamId(Long examId) {
        Exam exam = new Exam();
        try {
            exam = examRepository.findExamByExamId(examId);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return exam;

    }

    @Override
    public Exam createExam(ExamConfigDto configDto) {
        log.info(configDto.toString());
        String examName = configDto.getExamName();
        Long classId = configDto.getClassId();
        Long examQuestionCount = configDto.getExamQuestionCount();
        // todo
        //  probably there could have bug
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(configDto.getExamStartTimeStamp(), formatter);
        LocalDateTime endTime = LocalDateTime.parse(configDto.getExamEndTimeStamp(), formatter);

        Timestamp examStartTimeStamp = Timestamp.valueOf(startTime);
        Timestamp examEndTimeStamp = Timestamp.valueOf(endTime);
        log.info(examStartTimeStamp.toString());
        Exam exam = new Exam();

        exam.setExamName(examName);
        exam.setExamQuestionCount(examQuestionCount);
        exam.setExamStartTimeStamp(examStartTimeStamp);
        exam.setExamEndTimeStamp(examEndTimeStamp);
        List<User> allUsers = userRepository.findAllByUserClassId(classId);
        List<User> students = new ArrayList<>();
        // filter student

        for (User user : allUsers) {
            if (user.getUserRoleLevel() == 2) {
                students.add(user);
            }
        }
        if (students.size() == 0) {
            log.info(examName);
            return exam;
        }

        try {
            // save exam infomation
            Exam savedExam = examRepository.save(exam);
            log.info("students: " + students.size());
            for (User student : students) {
                ExamRecord record = new ExamRecord();
                record.setExamId(savedExam.getExamId());
                record.setUserId(student.getUserId());
                record.setClassId(classId);
                record.setExamStatus(0L);
                examRecordRepository.save(record);
            }
            log.info("create exam successfully!!!!  !");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return exam;
    }

    @Override
    public Long judgeExam(@org.jetbrains.annotations.NotNull QuestionAnswerSheetDto answerSheet) {
        Long score = 0L;

        Long userId = answerSheet.getUserId();
        Long examId = answerSheet.getExamId();
        List<MetaQuestionAnswer> metaQuestionAnswers = answerSheet.getQuestionAnswers();
        // get score
        for (MetaQuestionAnswer answer : metaQuestionAnswers) {
            Long questionId = answer.getQuestionId();
            String questionAnswer = answer.getSheetAnswer();
            log.info(questionAnswer);
            Question question = questionRepository.getQuestionByQuestionId(questionId);
            if (question == null || questionAnswer == null) {
                continue;
            }
            if (question.getQuestionType().equalsIgnoreCase("multiple")) {
                boolean multipleCorrect = true;
                List<String> correctAnswers = List.of(question.getQuestionAnswer().split("$"));
                List<String> sheetAnswers = List.of(answer.getSheetAnswer().split("$"));
                if (correctAnswers.size() != sheetAnswers.size()) {
                    continue;
                }
                log.info("correct size:" + correctAnswers.size() + "sheet answer size: " + sheetAnswers.size());
                if (sheetAnswers.size() > 1) {
                    Collections.sort(correctAnswers);
                    Collections.sort(sheetAnswers);
                }

                for (int i = 0; i < correctAnswers.size(); i++) {
                    log.info("test answer: ");
                    if (!correctAnswers.get(i).equalsIgnoreCase(sheetAnswers.get(i))) {
                        multipleCorrect = false;
                        break;
                    }
                }
                if (multipleCorrect) {
                    score += 1L;
                }

            } else {
                if (questionAnswer.equalsIgnoreCase(question.getQuestionAnswer())) {
                    score += 1L;
                }

            }
        }
        log.info("Judge called");

        // label the examRecord finished.
        examRecordRepository.updateExamRecordByExamId(examId, userId, 1L, score);
        return score;
    }
}
