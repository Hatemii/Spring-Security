package com.example.demo.Security;

import com.google.common.collect.Sets;

import java.util.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),

    ADMIN(Sets.newHashSet(
            ApplicationUserPermission.COURSE_READ,
            ApplicationUserPermission.COURSE_WRITE,
            ApplicationUserPermission.STUDENT_READ,
            ApplicationUserPermission.STUDENT_WRITE
    ));

    private final Set<ApplicationUserPermission> permissions;

    // constructor
    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    // getter
    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
