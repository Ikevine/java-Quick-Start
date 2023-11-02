package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args ->{
            Student kevine =  new Student(
                    1L,
                     "kevine",
                     "kevine@gmail.com",
                     LocalDate.of(2022 , 04 , 23)
             );
            Student divine =  new Student(
                    2L,
                    "Divine",
                    "Divine@gmail.com",
                    LocalDate.of(2002 , 04 , 23)
            );


           repository.saveAll(
                    List.of(kevine, divine)
            );
        };
    }
}
