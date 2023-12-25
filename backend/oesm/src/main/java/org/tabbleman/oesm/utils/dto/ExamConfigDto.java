package org.tabbleman.oesm.utils.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class ExamConfigDto {
//    private Long subjectId;
    private String examName;
    private Long classId;
    private Long examQuestionCount;
    private Long singleCount;
    private Long singleScore;
    private Long multipleCount;
    private Long multipleScore;
    private Long truefalseCount;
    private Long truefalseScore;

    private String examStartTimeStamp;

    private String  examEndTimeStamp;
}
