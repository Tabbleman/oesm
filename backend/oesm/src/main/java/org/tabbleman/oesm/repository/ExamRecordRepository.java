package org.tabbleman.oesm.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.tabbleman.oesm.entity.Exam;
import org.tabbleman.oesm.entity.ExamRecord;
import org.tabbleman.oesm.entity.User;

import java.util.List;

// student and exam many to many relation ship, slice them int to two part

public interface ExamRecordRepository extends JpaRepository<ExamRecord, String> {
    public List<ExamRecord> findAllByUserId(Long userId);
//    public void deleteAllByExamId(Long examId);
    @Modifying
    @Transactional
    @Query("update ExamRecord er set er.examStatus = :status, er.examScore = :score where er.examId = :examId and er.userId = :userId")
    public void updateExamRecordByExamId(Long examId, Long userId, Long status, Long score);

}
