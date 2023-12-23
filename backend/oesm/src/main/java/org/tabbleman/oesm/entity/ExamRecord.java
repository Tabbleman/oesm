package org.tabbleman.oesm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ExamRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examRecordId;
//     1 for finish, 0 for not
    private Long examStatus;
//     exam record for specific subject
//    private Long subjectId;
    private Long classId;
    private Long examId;
    private Long userId;
    private Long examScore;

}
