package com.zavolsky.course_02.services;

import com.zavolsky.course_02.exceptions.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalcImplTest {

    private final CalcImpl calc = new CalcImpl();

    @Test
    public void plusTest() {
        Assertions.assertEquals(calc.plus(5,5),10);
        Assertions.assertEquals(calc.plus(2,1),3);
    }

    @Test
    public void minusTest() {
        Assertions.assertEquals(calc.minus(5,5),0);
        Assertions.assertEquals(calc.minus(2,1),1);
    }

    @Test
    public void multiplyTest() {
        Assertions.assertEquals(calc.multiply(5,5),25);
        Assertions.assertEquals(calc.multiply(2,1),2);
    }

    @Test
    public void divideTest() {
        Assertions.assertEquals(calc.divide(5,5),(double) 1);
        Assertions.assertEquals(calc.divide(2,1),(double) 2);
    }

    @Test
    public void divideNegativeTest() {
        Assertions.assertThrows(BadRequestException.class,() -> calc.divide(2,0));
        Assertions.assertThrows(BadRequestException.class,() -> calc.divide(0,0));
    }
}