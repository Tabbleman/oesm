package org.tabbleman.oesm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
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

    private Long examQuestionCount = 10L;

//    dan xuan
    private Long examQuestionSingleCount = 3L;
//    duo xuan
    private Long examQuestionMultipleCount = 3L;
//     pan duan
    private Long examQuestionTfCount = 4L;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp examStartTimeStamp;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp examEndTimeStamp;

}
