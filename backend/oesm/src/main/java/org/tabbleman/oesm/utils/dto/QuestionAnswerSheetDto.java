package org.tabbleman.oesm.utils.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionAnswerSheetDto {

    private Long userId;
    private Long examId;

    private List<MetaQuestionAnswer> questionAnswers;
}
