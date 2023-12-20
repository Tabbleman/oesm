package org.tabbleman.oesm.service;

import org.springframework.web.multipart.MultipartFile;
import org.tabbleman.oesm.entity.Question;

import java.util.List;

public interface QuestionService {
    public List<Question> getAllQuestions();

    public List<Question> getAllSingleQuestions();

    public List<Question> getAllMultipleQuestions();

    public List<Question> getAllTfQuestions();

    public String uploadQuestion(MultipartFile questionCsv);
}
