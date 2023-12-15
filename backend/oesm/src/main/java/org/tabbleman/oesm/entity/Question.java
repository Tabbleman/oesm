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
     * single
     * multiple
     * truefalse
     */
    private String questionType;
    private String questionName;
    /**
     * answer is the content of the choices.
     * e
     */
    private String questionAnswer;
    /**
     * choice splict format:
     * "[]$[]$[]$[]"
     * "T$F"
     */
    private String questionChoices = "hello world$goodgood$fucn u$test";
}
