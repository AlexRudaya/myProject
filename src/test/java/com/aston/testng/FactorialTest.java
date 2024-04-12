package com.aston.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FactorialTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void possitiveNumbers() {
        Factorial positive = new Factorial();
        softAssert.assertEquals(120, positive.getFactorial(5));
        softAssert.assertEquals(1, positive.getFactorial(1));
        softAssert.assertEquals(1, positive.getFactorial(0));
        softAssert.assertEquals(738197504, positive.getFactorial(31));
        softAssert.assertAll();
    }

    //  @Test(expectedExceptions = IllegalArgumentException.class)
    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Number can't be negative")
    public void negativeNumber() {
        Factorial negative = new Factorial();
        negative.getFactorial(-1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Result is outOfBound")
    public void outOfBoundNumber() {
        Factorial outOfBound = new Factorial();
        outOfBound.getFactorial(32);
    }

}