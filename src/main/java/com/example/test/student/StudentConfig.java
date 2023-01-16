//package com.example.test.student;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class StudentConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository) {
//        return args -> {
//            Student omar = new Student(
//                    "omar",
//                    "omar@gmail.com",
//                    LocalDate.of(2000, Month.JANUARY, 5)
//            );
//
//            Student mariam = new Student(
//                    "mariam",
//                    "mari@gmail.com",
//                    LocalDate.of(2000, Month.APRIL, 10)
//            );
//
//            repository.saveAll(
//                    List.of(mariam, omar)
//            );
//        };
//    }
//}
