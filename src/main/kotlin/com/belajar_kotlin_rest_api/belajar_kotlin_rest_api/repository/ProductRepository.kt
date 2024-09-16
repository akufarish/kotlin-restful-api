package com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.repository

import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, String> {
}