package org.tabbleman.oesm.repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tabbleman.oesm.entity.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, String> {
    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT :n", nativeQuery = true)
    List<Question> generateQuestions(@Param("n") int n);

}
