package com.kevin.schoolApp.service;

import com.kevin.schoolApp.entity.Student;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface StudentService {
    List<Student> findStudents(String name,int age, String major);
}
