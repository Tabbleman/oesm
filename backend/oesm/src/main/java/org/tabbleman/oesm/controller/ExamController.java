package org.tabbleman.oesm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tabbleman.oesm.entity.Exam;
import org.tabbleman.oesm.entity.Question;
import org.tabbleman.oesm.repository.ExamRepository;
import org.tabbleman.oesm.service.ExamService;
import org.tabbleman.oesm.utils.qo.ExamQo;
import org.tabbleman.oesm.utils.qo.UserExamsQo;

import java.util.ArrayList;
import java.util.List;

/**
 * todo:
 * Exam controller
 * functions                Actor               Descriptions
 *
 * @Get getAllExams              student
 * getAllQuestions          Teacher
 * getAllSingleQuestions    Teacher
 * getAllMultipleQuestion   Teacher
 * getAllTFQuestion         Teacher
 * @Post updateExam               Student
 * addNewQuestion           Teacher
 * createExam               Teacher             need pick different number of different type of question
 * finishExam               Student
 */
@RestController
@CrossOrigin
@RequestMapping("/api/exam")
public class ExamController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ExamService examService;

    /**
     * for login user to view their task
     *
     * @param userExamsQo
     * @return
     */
    @PostMapping("/user/exams")
    ResponseEntity<List<Exam>> getUserExams(@RequestBody UserExamsQo userExamsQo) {
        List<Long> examIdList = examService.getUserExamsId(userExamsQo);
        List<Exam> exams = new ArrayList<>();
        logger.info("user id info:" + userExamsQo.getUserId() );
        if (examIdList.isEmpty()) {
            logger.info("Empty info");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(exams);
        }
        for (Long examId : examIdList) {
            Exam exam = examService.getExamByExamId(examId);
            if (exam != null) {
                exams.add(exam);
            }
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(exams);

    }
    @GetMapping(path = "/{examId}")
    ResponseEntity<List<Question>> generateQuestionsByExamId(@PathVariable Long examId){
        List<Question> questions = new ArrayList<>();
        try {
            questions = examService.generateQuestionsByExamId(examId);

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(questions);
    }

}
