package org.tabbleman.oesm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * todo different level of difficulty, different subject of question
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    private Long questionId;
    /**
     * danxuan
     * duoxuan
     * panduan
     */
    private String questionType;
    private String questionName;
    private String questionAnswer;

    /**
     * choice splict format:
     * "A.[]$B.[]$C.[]$D.[]"
     * "T$F"
     */
    private String questionChoices = "A.hello world$B.goodgood$C. fucn u$D.test";
}
