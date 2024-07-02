package com.example.products.dto

data class Product(
    var id: Int,
    var description: String,
    var name: String,
    var price: Int,
    var stockQuantity: Int
)

data class UpdateProductPriceRequest(
    var id: Int,
    var price: Int,
)