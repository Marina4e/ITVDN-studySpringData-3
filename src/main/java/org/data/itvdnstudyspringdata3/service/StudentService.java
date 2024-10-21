package org.data.itvdnstudyspringdata3.service;

import org.data.itvdnstudyspringdata3.model.Student;
import org.data.itvdnstudyspringdata3.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<?> createStudent(Student student) {
        studentRepository.save(student);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    public ResponseEntity<Student> getStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
