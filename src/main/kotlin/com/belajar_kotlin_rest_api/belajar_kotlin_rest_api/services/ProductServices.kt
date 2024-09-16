package com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.services

import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.entity.Product
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.models.CreateProductRequest
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.models.ProductResponses
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.models.WebResponses
import java.util.*

interface ProductServices {
    fun create(request: CreateProductRequest): ProductResponses

    fun index(): MutableList<Product>

    fun show(id: String): Optional<Product>

    fun update(id: String, request: CreateProductRequest): ProductResponses

    fun delete(id: String): WebResponses<String>
}