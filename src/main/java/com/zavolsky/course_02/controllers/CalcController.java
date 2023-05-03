package com.zavolsky.course_02.controllers;

import com.zavolsky.course_02.services.CalcImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(path = "/calculator")
public class CalcController {

    private final CalcImpl calcImpl;

    public CalcController(CalcImpl calcImpl) {
        this.calcImpl = calcImpl;
    }

    @GetMapping
    public String greetings() {
        return calcImpl.greetings();
    }

    @GetMapping(path = "plus")
    public String plus(@RequestParam(value = "num1", required = false) int num1,
                       @RequestParam(value = "num2", required = false) int num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return "Введите оба параметра.";
        }
        return String.format("%d + %d = %d",num1, num2, calcImpl.plus(num1, num2));
    }

    @GetMapping(path = "minus")
    public String minus(@RequestParam(value = "num1", required = false) int num1,
                        @RequestParam(value = "num2", required = false) int num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return "Введите оба параметра.";
        }
        return String.format("%d - %d = %d",num1, num2, calcImpl.minus(num1, num2));
    }

    @GetMapping(path = "multiply")
    public String multiply(@RequestParam(value = "num1", required = false) int num1,
                           @RequestParam(value = "num2", required = false) int num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return "Введите оба параметра.";
        }
        return String.format("%d * %d = %d",num1, num2, calcImpl.multiply(num1, num2));
    }

    @GetMapping(path = "divide")
    public String divide(@RequestParam(value = "num1", required = false) int num1,
                         @RequestParam(value = "num2", required = false) int num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            return "Введите оба параметра.";
        }
        return String.format("%d / %d = %.2f",num1, num2, calcImpl.divide(num1, num2));
    }
}
