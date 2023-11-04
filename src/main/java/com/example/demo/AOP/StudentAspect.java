package com.example.demo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class StudentAspect {

    //before the student is saved I need tosee the time to reach it *-> is method
    //Signature name of the method that is being called
    @Before(value = "execution(* com.example.demo.student.StudentController.*(..))")
    public void beforeStudentAdvics(JoinPoint joinPoint){
        System.out.println("Hellow everyone"+ joinPoint.getSignature()+ "Im storing student" + new Date());
    }
}
