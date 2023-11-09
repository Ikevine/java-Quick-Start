package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private static StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static List<Student> getStudents() {
        return  studentRepository.findAll();
    }

//    public void addNewStudent(Student student) {
//        //business logic
//        Optional studentByEmail =  studentRepository.findStudentByEmail(student.getEmail());
//        if(studentByEmail.isPresent()){
//            throw new IllegalStateException("Email is taken");
//        }
//        studentRepository.save(student);
//    }

    public void deleteStudent(Long id) {
        //deleting a student we need to know that we have them
        boolean exist = studentRepository.existsById(id);
        if(!exist){
             throw new IllegalStateException("student with id " + id +" Does not exist");
        }
        studentRepository.deleteById(id);
    }

  @Transactional   // We did use any query
    public void updateStudent(Long id, String name, String email) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id doesn't exist"
                ));

        if(name != null && name.length()>0 && !Objects.equals(student.getName() , name))
        {
            student.setName(name);
        }

//        if(email != null && email.length()>0 && Objects.equals(student.getEmail(), email)){
//            //check if the email is taken
//            Optional<Student> emailtaken = studentRepository.findStudentByEmail(email);
//            if (emailtaken.isPresent()){
//                throw new IllegalStateException();
//            }
//            student.setEmail(email);
//        }
    }
}
