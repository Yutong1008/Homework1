package com.example.demo.student.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    List<Student> getStudents() {

        return studentRepository.findAll();
    }

    @PostMapping
    Student createStudent(@RequestBody Student student) {

        return studentRepository.save(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentRepository.deleteStudent(id);
    }
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Set<Long> courses_enrolled
    ) {
        studentRepository.updateStudent(id, name, courses_enrolled);
    }
}