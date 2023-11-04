package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {


     private final StudentService studentService;

    @Autowired
     public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

   @GetMapping
    public List<Student> getStudent(){
       return StudentService.getStudents();
    }


    @PostMapping
    public void registerStudent(@RequestBody  Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void update(@PathVariable("studentId") Long id,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String email
     )
    {
        studentService.updateStudent(id , name , email);
    }

    @GetMapping("details")
    public String details(){
        return "Hellow I love all";
    }

}
