package org.tabbleman.oesm.entity;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Exam {
    @Id
    private Long examId;
    private String examName;
    private String examQuestionCount = "10";
//    dan xuan
    private String examQuestionSingleCount = "3";
//    duo xuan
    private String examQuestionMultipleCount = "3";
//     pan duan
    private String examQuestionTFCount = "4";

    private Integer examTotalScore;


    private String examQuestionSingleScore;
    private String examQuestionMultipleScore;
    private String examQuestionTFScore;

    private String examTimeLimit;

    private Date examStartTimeStamp;
    private Date examEndTimeStamp;

}
