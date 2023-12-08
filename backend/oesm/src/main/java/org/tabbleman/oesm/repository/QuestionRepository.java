package org.tabbleman.oesm.repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.tabbleman.oesm.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, String> {
}
