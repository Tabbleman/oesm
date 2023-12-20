package org.tabbleman.oesm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ExamRecord {
    @Id
    private Long examRecordId;
    // 1 for finish, 0 for not
    private Long examStatus;
//     exam record for specific subject
//    private Long subjectId;

    private Long examId;
    private Long userId;

}
