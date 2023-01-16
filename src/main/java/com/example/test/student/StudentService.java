package com.example.test.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    record NewStudentRequest(Integer age, LocalDate dob, String email, String name) {}

    public void registerStudent(Student student)  {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    /**
     * @param studentId
     * @param name - optional field because of the annotation @Transactional
     * @param email - optional field
     * @param student
     */
    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email,
                              Student student) {
        boolean exist = studentRepository.existsById(studentId);
        if(!exist) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist!");
        }
        studentRepository.save(student); // set the attributes that have been changed
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}
