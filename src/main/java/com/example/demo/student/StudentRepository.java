package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//responsive for our database
//are used in our service to implement the logic
public interface StudentRepository extends JpaRepository<Student , Long> {

    Optional<Student> findStudentByEmail(String email);

}
