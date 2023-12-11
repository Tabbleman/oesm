package org.tabbleman.oesm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tabbleman.oesm.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, String> {
    Exam findExamByExamName(String examName);
    Exam findExamByExamId(Long examId);
}
