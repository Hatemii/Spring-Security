package com.example.demo.Student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James"),
            new Student(2, "Mark"),
            new Student(3, "Tom")
    );

    // management
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    // insert
    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void insertStudent(@RequestBody Student student) {
        System.out.println(student);
    }

    // update
    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        System.out.printf(String.format("%s %s", id, student));
    }

    // delete
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("id") int id) {
        System.out.println(id);
    }

}

/**
 * @PreAuthorize annotation is used on a method level.
 * ..
 * 1. When using the hasRole() security expression, the prefix ROLE_ is skipped.
 * This is because Spring Framework will add the prefix automatically for us.
 * ..
 * 2. When you need to support multiple roles, you can use the hasAnyRole() expression.
 * ..
 * 3. @PreAuthorize annotation can also be used with hasAuthority(). When using hasAuthority() expression,
 * you will need to provide a complete authority name.
 * ..
 * 4. When you need to support multiple authorities, hasAnyAuthority() expression can be used.
 */
