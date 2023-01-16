package com.example.test.student;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name="student_sequence", sequenceName = "student_sequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")

    private Long id;

    // the annotation below means, exclude this column from DB
    @Transient
    private Integer age;
    private LocalDate dob;
    private String email, name;

    public Student() {}

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.dob = dob;
        this.email = email;
        this.name = name;
    }

    public Student(String name, String email, LocalDate dob) {
        this.dob = dob;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(age, student.age) && Objects.equals(dob, student.dob) && Objects.equals(email, student.email) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, dob, email, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
