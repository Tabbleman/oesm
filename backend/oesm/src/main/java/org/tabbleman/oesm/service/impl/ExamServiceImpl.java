package org.tabbleman.oesm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tabbleman.oesm.entity.Exam;
import org.tabbleman.oesm.entity.Question;
import org.tabbleman.oesm.repository.ExamRepository;
import org.tabbleman.oesm.repository.QuestionRepository;
import org.tabbleman.oesm.service.ExamService;

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

}
