package com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.models

import jakarta.validation.constraints.NotBlank

data class CreateProductRequest(
    @field:NotBlank
    val nama: String,

    @field:NotBlank
    val desc: String,
)