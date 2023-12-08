package org.tabbleman.oesm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tabbleman.oesm.entity.Exam;
import org.tabbleman.oesm.entity.Question;
import org.tabbleman.oesm.repository.ExamRepository;
import org.tabbleman.oesm.repository.QuestionRepository;
import org.tabbleman.oesm.service.ExamService;
import org.tabbleman.oesm.utils.dto.ExamConfigDto;

import java.util.Date;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamRepository examRepository;
    @Autowired
    QuestionRepository questionRepository;

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

    @Override
    public Exam createExam(ExamConfigDto configDto) {
        Exam exam = new Exam();
        exam.setExamName("Sample Exam");
        exam.setExamQuestionSingleCount(configDto.getQuestionSingleCount());
        exam.setExamQuestionMultipleCount(configDto.getQuestionMultipleCount());
        exam.setExamQuestionTfCount(configDto.getQuestionTfCount());
        // Set start and end timestamps
        exam.setExamStartTimeStamp(new Date());
        try{
            examRepository.save(exam);
            return exam;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
