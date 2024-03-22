package com.kevin.schoolApp.controller;

import com.kevin.schoolApp.entity.Student;
import com.kevin.schoolApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/search")
    public List<Student> findStudents(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "age", defaultValue = "0") int age,
            @RequestParam(value = "major", required = false) String major
    ) {
        return studentService.findStudents(name,age ,major);
    }
}
