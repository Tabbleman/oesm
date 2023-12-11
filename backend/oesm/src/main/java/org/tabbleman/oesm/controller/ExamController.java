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

import java.util.List;

/**
 * todo:
 * Exam controller
 * functions                Actor               Descriptions
 * @Get
 * getAllExams              Teacher, Admin
 * getAllQuestions          Teacher
 * getAllSingleQuestions    Teacher
 * getAllMultipleQuestion   Teacher
 * getAllTFQuestion         Teacher
 *
 * @Post
 * updateExam               Student
 * addNewQuestion           Teacher
 * createExam               Teacher             need pick different number of different type of question
 * finishExam               Student
 */
@RestController
@RequestMapping("/api/exam")
public class ExamController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ExamService examService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> questions = examService.getAllQuestions();
        logger.info("testing getquestion api");
        if(questions != null){
            return ResponseEntity.ok(questions);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    // return exma for testing

//    @PostMapping("/create")
//    /*todo exam configuration*/
//    public ResponseEntity<Exam> createExam(@RequestBody ExamConfigDto examConfig){
//        Exam exam = examService.createExam(examConfig);
//        return  ResponseEntity.ok(exam);
//    }

//    @PostMapping("/test")
//    /*todo exam configuration*/
//    public ResponseEntity<Exam> test(@RequestBody ExamConfigDto examConfig){
//        Exam exam = examService.createExam(examConfig);
//        return  ResponseEntity.ok(exam);
//    }
}
