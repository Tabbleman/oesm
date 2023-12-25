package org.tabbleman.oesm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    // Use GenerationType.IDENTITY for auto-increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
//    for teacher, this section default value is null.
    private Long userClassId = null;
    private String userRealName;

    private String userPassword;
    private Long userRoleLevel = 2L;
    private String userEmail;

    public User(String userName, Long userClassId, String userRealName, String userPassword, Long userRoleLevel, String userEmail) {
        this.userName = userName;
        this.userClassId = userClassId;
        this.userRealName = userRealName;
        this.userPassword = userPassword;
        this.userRoleLevel = userRoleLevel;
        this.userEmail = userEmail;
    }
}
