package com.example.demo;

import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CalculatorTesting {

    @Test
    public void testAdditon(){
        //creating a mock object for calculator class
        Calculator calculatorMock = Mockito.mock(Calculator.class);
        //set the expected result
        Mockito.when(calculatorMock.add(2 , 3)).thenReturn(5);
        //call the method under test
        int result = calculatorMock.add(2,3);
        //assert the expected result
        Assert.assertEquals(5, result);

    }
}
