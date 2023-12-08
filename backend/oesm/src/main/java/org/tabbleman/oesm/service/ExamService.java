package org.tabbleman.oesm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tabbleman.oesm.entity.Exam;
import org.tabbleman.oesm.entity.Question;
import org.tabbleman.oesm.repository.ExamRepository;
import org.tabbleman.oesm.utils.dto.ExamConfigDto;

import java.util.List;

/**
 * todo pick question of specific level or range of level;
 *
 * todo:
 */
public interface ExamService {

    public List<Question> getAllQuestions();

    public List<Question> getAllSingleQuestions();

    public List<Question> getAllMultipleQuestions();

    public List<Question> getAllTfQuestions();

    public Exam createExam(ExamConfigDto configDto);

}
