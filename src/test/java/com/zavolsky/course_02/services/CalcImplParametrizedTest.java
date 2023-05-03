package com.zavolsky.course_02.services;

import com.zavolsky.course_02.exceptions.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalcImplParametrizedTest {
    private final CalcImpl calc = new CalcImpl();

    public static Stream<Arguments> plusTestParams() {
        return Stream.of(
                Arguments.of(5,5,10),
                Arguments.of(2,1,3)
        );
    }

    public static Stream<Arguments> minusTestParams() {
        return Stream.of(
                Arguments.of(5,5,0),
                Arguments.of(2,1,1)
        );
    }

    public static Stream<Arguments> multiplyTestParams() {
        return Stream.of(
                Arguments.of(5,5,25),
                Arguments.of(2,1,2)
        );
    }

    public static Stream<Arguments> divideTestParams() {
        return Stream.of(
                Arguments.of(5,5,(double) 1),
                Arguments.of(2,1,(double) 2)
        );
    }

    public static Stream<Arguments> divideNegativeTestParams() {
        return Stream.of(
                Arguments.of(5,0),
                Arguments.of(2,0)
        );
    }

    @ParameterizedTest
    @MethodSource("plusTestParams")
    public void plusTest(int num1, int num2, Number expected) {
        Assertions.assertEquals(calc.plus(num1,num2),expected);
    }

    @ParameterizedTest
    @MethodSource("minusTestParams")
    public void minusTest(int num1, int num2, Number expected) {
        Assertions.assertEquals(calc.minus(num1,num2),expected);
    }

    @ParameterizedTest
    @MethodSource("multiplyTestParams")
    public void multiplyTest(int num1, int num2, Number expected) {
        Assertions.assertEquals(calc.multiply(num1,num2),expected);
    }

    @ParameterizedTest
    @MethodSource("divideTestParams")
    public void divideTest(int num1, int num2, Number expected) {
        Assertions.assertEquals(calc.divide(num1,num2),(double) expected);
    }

    @ParameterizedTest
    @MethodSource("divideNegativeTestParams")
    public void divideNegativeTest(int num1, int num2) {
        Assertions.assertThrows(BadRequestException.class,() -> calc.divide(num1,num2));
    }
}
