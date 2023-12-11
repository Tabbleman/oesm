package org.tabbleman.oesm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tabbleman.oesm.entity.Exam;
import org.tabbleman.oesm.entity.ExamRecord;
import org.tabbleman.oesm.entity.Question;
import org.tabbleman.oesm.repository.ExamRecordRepository;
import org.tabbleman.oesm.repository.ExamRepository;
import org.tabbleman.oesm.repository.QuestionRepository;
import org.tabbleman.oesm.service.ExamService;
import org.tabbleman.oesm.utils.qo.UserExamsQo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamRepository examRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    ExamRecordRepository examRecordRepository;

    /**
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * api for user
     * @param userExamsQo
     * @return
     */
    @Override
    public List<Long> getUserExamsId(UserExamsQo userExamsQo) {
        List<ExamRecord> examRecords = new ArrayList<>();
        List<Long> examIds = new ArrayList<>();
        try{
            Long userId = userExamsQo.getUserId();
            examRecords = examRecordRepository.findAllByUserId(userExamsQo.getUserId());
            examIds = examRecords.stream()
                    .map(ExamRecord::getExamId)
                    .collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
        }

        return examIds;
    }

    /**
     * this function is for single exam detail view in front end
     * @param examId
     * @return
     */
    @Override
    public Exam getExamByExamId(Long examId) {
        Exam exam = new Exam();
        try {
            exam = examRepository.findExamByExamId(examId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return exam;

    }

    /**
     * todo handle null scenario.
     * @return
     */
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getAllSingleQuestions() {
        return null;
    }

    @Override
    public List<Question> getAllMultipleQuestions() {
        return null;
    }

    @Override
    public List<Question> getAllTfQuestions() {
        return null;
    }


}
