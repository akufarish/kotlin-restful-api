package com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.services.impl

import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.entity.Product
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.models.CreateProductRequest
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.models.ProductResponses
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.models.WebResponses
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.repository.ProductRepository
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.services.ProductServices
import com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.validation.ValidationUtils
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtils: ValidationUtils
    ): ProductServices {
    override fun create(request: CreateProductRequest): ProductResponses {
        validationUtils.validate(request)

        val product = Product(
            id = null,
            nama = request.nama,
            desc = request.desc,
            createdAt = Date(),
            updatedAt = null
        )

        productRepository.save(product)

        return ProductResponses(
            id = product.id!!,
            nama = product.nama,
            desc = product.desc
        )
    }

    override fun index(): MutableList<Product> {
        return productRepository.findAll()
    }

    override fun show(id: String): Optional<Product> {
        return productRepository.findById(id)
    }

    override fun update(id: String, request: CreateProductRequest): ProductResponses {
        val product =  productRepository.findByIdOrNull(id)

        if (product == null) {
            throw NotFoundException()
        }

        product.apply {
            nama = request.nama
            desc = request.desc
        }

        productRepository.save(product)
        return convertToProductResponses(product)
    }

    override fun delete(id: String): WebResponses<String> {
        val product = productRepository.deleteById(id)

        return WebResponses(
            code = 200,
            status = "DELETED",
            data = "Data berhasil dihapus"
        )
    }

    private fun convertToProductResponses(product: Product) : ProductResponses {
        return ProductResponses(
            nama = product.nama,
            desc = product.desc,
            id = product.id!!
        )
    }
}