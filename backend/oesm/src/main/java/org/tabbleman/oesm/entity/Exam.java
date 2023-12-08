package org.tabbleman.oesm.entity;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

/**
 * todo add time limit for the exam, different subject, different question score
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;
    private String examName;
    private String examQuestionCount = "10";
//    dan xuan
    private String examQuestionSingleCount = "3";
//    duo xuan
    private String examQuestionMultipleCount = "3";
//     pan duan
    private String examQuestionTfCount = "4";

//    private Integer examTotalScore;

//    private String examQuestionSingleScore;
//    private String examQuestionMultipleScore;
//    private String examQuestionTFScore;

//    private String examTimeLimit;
    private Date examStartTimeStamp;
    private Date examEndTimeStamp;

}
