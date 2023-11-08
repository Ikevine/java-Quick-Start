package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@SpringBootTest
class DemoApplicationTests {

	//crating test underTesting method
	Calculator underTest = new Calculator();

	@Test
	void addTwoNumbers(){
		//given
		int num1 = 10;
		int num2 = 20;
		//when
		int result = underTest.add(num1, num2);
		//then
		Assert.assertEquals(30 , result);
	}
	class Calculator{
		int add (int a ,int b){
			return a+b;
		}
	}

}
