package org.tabbleman.oesm.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ADMIN(0, "Administrater"),
    TEACHER(1, "Teacher"),
    STUDENT(2, "Student");

    RoleEnum(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    private Integer id;
    private String roleName;
}
