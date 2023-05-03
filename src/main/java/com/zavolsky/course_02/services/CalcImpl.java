package com.zavolsky.course_02.services;

import com.zavolsky.course_02.CalcService;
import com.zavolsky.course_02.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class CalcImpl implements CalcService {
    public String greetings() {
        return "Добро пожаловать в калькулятор.";
    }

    public Number plus(int num1, int num2) {
        return num1 + num2;
    }

    public Number minus(int num1, int num2) {
        return num1 - num2;
    }

    public Number multiply(int num1, int num2) {
        return num1 * num2;
    }

    public Number divide(int num1, int num2) {
        if (num2 == 0) {
            throw new BadRequestException("Делить на ноль нельзя.");
        }
        return (double) num1 / num2;
    }
}
