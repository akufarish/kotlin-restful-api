package com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.controller

import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.models.WebResponses
import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorController {
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponses<String> {
        return WebResponses(
            code = 400,
            status = "BAD REQUEST",
            data = constraintViolationException.message!!
        )
    }
}