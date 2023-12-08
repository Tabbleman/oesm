package org.tabbleman.oesm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tabbleman.oesm.entity.Role;

public interface UserLevelRepository extends JpaRepository<Role, String > {
}
