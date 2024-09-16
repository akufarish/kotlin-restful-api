package com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.validation

import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validator
import org.springframework.stereotype.Component

@Component
class ValidationUtils(val validation: Validator) {
    fun validate(any: Any) {
        val result = validation.validate(any)

        if (result.size != 0) {
            throw ConstraintViolationException(result)
        }
    }
}
