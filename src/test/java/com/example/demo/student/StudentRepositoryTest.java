package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


//wiring everything without this we get the null pointer exception
//testing repository
@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    //starting the unit testing

    @Test
    public void testForStudentWithEmail(){
        String email = "kevin@gmail.com";
        //given
        Student student = new Student(
                5L,
                "Levine",
                email,
                LocalDate.of(2002,02,23)
        );
         studentRepository.save(student);
        //when
         Student expected = studentRepository.findStudentByEmail(email);
        //then

       assertEquals(student , expected , " all erros every Where");
    }
}