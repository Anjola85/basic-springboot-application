package com.example.test.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * This is the API layer
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/register")
    public void register(@RequestBody Student student) {
        studentService.registerStudent(student);
    }

    /**
     *
     * @param studentId - path variable, meaning the current url with the id added at the end of it
     * @param name - current url with name added at the end of it(must be preceded by '?')
     * @param email - same as name
     * @param student - this must be a JSON body submitted as a post request
     */
    @PutMapping("{studentId}")
    public void update(
            @PathVariable Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestBody Student student) {
        studentService.updateStudent(studentId, name, email, student);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
