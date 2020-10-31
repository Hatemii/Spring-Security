package com.example.demo.Student;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James"),
            new Student(2, "Mark"),
            new Student(3, "Tom")
    );

    @GetMapping
    @RequestMapping("/{id}")
    public Student getStudent(@PathVariable("id") Integer id) {

        return STUDENTS.stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + id + " does not exist"));
    }

}
