package com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.models

data class WebResponses<T>(
    val code: Int,
    val status: String,
    val data: T
)
