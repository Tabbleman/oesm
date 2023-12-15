package org.tabbleman.oesm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tabbleman.oesm.entity.Exam;
import org.tabbleman.oesm.entity.Question;
import org.tabbleman.oesm.repository.ExamRepository;
import org.tabbleman.oesm.utils.qo.ExamQo;
import org.tabbleman.oesm.utils.qo.UserExamsQo;

import java.util.List;

/**
 * todo pick question of specific level or range of level;
 *
 * todo:
 */
public interface ExamService {
    // for student:
    public List<Long> getUserExamsId(UserExamsQo userExamsQo);

    public Exam getExamByExamId(Long examId);

    public List<Question> generateQuestionsByExamId(Long examId);


//    public Exam createExam(ExamConfigDto configDto);

}
