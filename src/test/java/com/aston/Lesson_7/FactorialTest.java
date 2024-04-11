package com.aston.Lesson_7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FactorialTest {
  @Test
    public void getFactorial(){
      Factorial factorial=new Factorial(5);
      int result=factorial.getFactorial();
      assertEquals(120,result);
  }

}