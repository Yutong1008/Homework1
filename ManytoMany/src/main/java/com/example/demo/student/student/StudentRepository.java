package com.example.demo.student.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteStudent(Long id);
    void updateStudent(Long id, String name, Set<Long> courses_enrolled);
}
