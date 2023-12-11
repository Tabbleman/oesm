package org.tabbleman.oesm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ExamRecord {
    @Id
    private Long examRecordId;
    private Long examId;
    private Long userId;

}
