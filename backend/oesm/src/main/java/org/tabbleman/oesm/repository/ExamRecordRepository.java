package org.tabbleman.oesm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tabbleman.oesm.entity.Exam;
import org.tabbleman.oesm.entity.ExamRecord;
import org.tabbleman.oesm.entity.User;

import java.util.List;

// student and exam many to many relation ship, slice them int to two part

public interface ExamRecordRepository extends JpaRepository<ExamRecord, String> {
    public List<ExamRecord> findAllByUserId(Long userId);
}
