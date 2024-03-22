package com.kevin.schoolApp.service;

import com.kevin.schoolApp.entity.Student;
import com.kevin.schoolApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findStudents(String name,int age, String major) {
        Specification<Student> spec = (root, query, criteriaBuilder) -> {
            // Inisialisasi list of predicates
            List<Predicate> predicates = new ArrayList<>();

            // Tambahkan predikat jika nilai parameter tidak null atau kosong
            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }
            if (age != 0) {
                predicates.add(criteriaBuilder.equal(root.get("age"), age));
            }
            if (major != null && !major.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("major"), major));
            }
            // Gabungkan semua predikat dengan operator AND
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return studentRepository.findAll(spec);
    }


}
