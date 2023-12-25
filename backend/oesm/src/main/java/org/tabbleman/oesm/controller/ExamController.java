package org.tabbleman.oesm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tabbleman.oesm.entity.Exam;
import org.tabbleman.oesm.entity.Question;
import org.tabbleman.oesm.service.ExamService;
import org.tabbleman.oesm.service.QuestionService;
import org.tabbleman.oesm.utils.dto.ExamConfigDto;
import org.tabbleman.oesm.utils.dto.QuestionAnswerSheetDto;
import org.tabbleman.oesm.utils.qo.UserExamsQo;
import org.tabbleman.oesm.utils.vo.ExamCardDisplayVo;

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
@CrossOrigin
@RestController
@RequestMapping("/api/exam")
public class ExamController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ExamService examService;

    @Autowired
    private QuestionService questionService;
    /**
     * for login user to view their task
     *
     * @param userExamsQo
     * @return
     */
    @PostMapping("/user/exams/unfinished")
    ResponseEntity<List<Exam>> getUserUnfinishedExams(@RequestBody UserExamsQo userExamsQo) {
        List<Exam> unfinishedExams = examService.getUserUnfinishedExams(userExamsQo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(unfinishedExams);

    }
    @PostMapping("/user/exams/finished")
    ResponseEntity<List<ExamCardDisplayVo>> getUserFinishedExams(@RequestBody UserExamsQo userExamsQo) {
        List<ExamCardDisplayVo> finishedExams = examService.getUserFinishedExams(userExamsQo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(finishedExams);

    }
    @PostMapping("/user/exams/all")
    ResponseEntity<List<Exam>> getUserAllExams(@RequestBody UserExamsQo userExamsQo) {
        List<Exam> allExams = examService.getUserAllExams(userExamsQo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(allExams);

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

    @PostMapping("/question/upload")
    ResponseEntity<String > uploadQuestion(@RequestParam("file") MultipartFile multipartFile){
        if(multipartFile != null){
            logger.info("received file");
            questionService.uploadQuestion(multipartFile);
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("File received");
    }

    /**
     * todo teacher pub exam for class, subject, student
     * @param examConfigDto
     * @return
     */
    @PostMapping("/create"  )
    ResponseEntity<Exam> createExam(@RequestBody ExamConfigDto examConfigDto){
        Exam exam = examService.createExam(examConfigDto);
        return ResponseEntity.status(HttpStatus.OK).body(exam);
    }

    @PostMapping("/judge")
    ResponseEntity<Long> judgeStudentExam(@RequestBody QuestionAnswerSheetDto answerSheetDto){
        Long score = examService.judgeExam(answerSheetDto);
        return ResponseEntity.status(HttpStatus.OK).body(score);
    }

//    @PostMapping("/user/history")
//    ResponseEntity<>

}
