package com.belajar_kotlin_rest_api.belajar_kotlin_rest_api.entity

import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.Date

@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener::class)
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column(name = "nama")
    var nama: String,

    @Column(name = "`desc`")  // Escape the reserved keyword
    var desc: String,

    @Column(name = "createdAt")
    val createdAt: Date?,

    @Column(name = "updatedAt")
    val updatedAt: Date?,
)