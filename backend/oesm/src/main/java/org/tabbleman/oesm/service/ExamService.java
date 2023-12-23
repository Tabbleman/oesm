package org.tabbleman.oesm.service;

import org.tabbleman.oesm.entity.Exam;
import org.tabbleman.oesm.entity.Question;
import org.tabbleman.oesm.utils.dto.ExamConfigDto;
import org.tabbleman.oesm.utils.dto.QuestionAnswerSheetDto;
import org.tabbleman.oesm.utils.qo.UserExamsQo;

import java.util.List;

/**
 * todo pick question of specific level or range of level;
 * todo:
 */
public interface ExamService {
    // for student:
    public List<Long> getUserExamsId(UserExamsQo userExamsQo);

    public List<Exam> getUserFinishedExams(UserExamsQo userExamsQo);
    public List<Exam> getUserAllExams(UserExamsQo userExamsQo);
    public List<Exam> getUserUnfinishedExams(UserExamsQo userExamsQo);

    public Exam getExamByExamId(Long examId);

    public List<Question> generateQuestionsByExamId(Long examId);


    public Exam createExam(ExamConfigDto configDto);

    public Long judgeExam(QuestionAnswerSheetDto answerSheet);

}
