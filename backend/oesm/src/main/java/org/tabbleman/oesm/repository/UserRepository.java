package org.tabbleman.oesm.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.tabbleman.oesm.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String userName);

    List<User> findAllByUserClassId(Long userClassId);

}
