package com.example.demo.Student;

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
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    // insert
    @PostMapping
    public void insertStudent(@RequestBody Student student) {
        System.out.println(student);
    }

    // update
    @PutMapping(value = "/{id}")
    public void updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        System.out.printf(String.format("%s %s", id, student));
    }

    // delete
    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        System.out.println(id);
    }

}
