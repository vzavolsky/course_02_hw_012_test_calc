package com.zavolsky.course_02.exceptions;

public class BadRequestException extends IllegalArgumentException{
    public BadRequestException(String message) {
        super(message);
    }
}
