package com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.controller

import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.entity.Product
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.models.CreateProductRequest
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.models.ProductResponses
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.models.WebResponses
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.services.ProductServices
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
class ProductController(val productServices: ProductServices) {
    @PostMapping(
        value = ["/api/v1/product"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody request: CreateProductRequest): WebResponses<ProductResponses> {
        val productResponses =  productServices.create(request)

        return WebResponses(
            code = 201,
            status = "Created",
            data = productResponses
        )
    }

    @GetMapping("/api/v1/product")
    fun indexProduct(): WebResponses<MutableList<Product>> {
        val product = productServices.index()

        return WebResponses(
            code = 200,
            status = "OK",
            data = product
        )
    }

    @GetMapping("/api/v1/product/{id}")
    fun showProduct(@PathVariable(value = "id") id: String): WebResponses<Optional<Product>> {
        val product = productServices.show(id)

        return WebResponses(
            code = 200,
            status = "OK",
            data = product
        )
    }

    @PutMapping(
        value = ["/api/v1/product/{id}"],
    )
    fun updateProduct(@PathVariable(value = "id") id: String,@RequestBody request: CreateProductRequest): WebResponses<ProductResponses> {
        val product = productServices.update(id, request)

        return WebResponses(
            code = 200,
            status = "OK",
            data = product
        )
    }

    @DeleteMapping("/api/v1/product/{id}")
    fun deleteProduct(@PathVariable(value = "id") id: String): WebResponses<String> {
        return productServices.delete(id)
    }
}