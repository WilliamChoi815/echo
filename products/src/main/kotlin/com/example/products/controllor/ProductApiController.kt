package com.example.products.controllor

import com.example.products.dto.Product
import com.example.products.dto.UpdateProductPriceRequest
import com.example.products.repository.ProductRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductApiController (
    val productRepository: ProductRepository
){

    @GetMapping("/products")
    fun getAll(): List<Product>{
        return productRepository.getAll()
    }

    @GetMapping("/products/{id}")
    fun getOne(@PathVariable id: Int): List<Product>{
        return productRepository.getById(id)
    }

    @PostMapping("/products")
    fun createProduct(
        @RequestBody product: Product
    ){
        productRepository.createProduct(product.description, product.name, product.price, product.stockQuantity)
    }

    @PatchMapping("/products")
    fun updateProduct(
        @RequestBody request: UpdateProductPriceRequest
    ){
        productRepository.updateProduct(request.price, request.id)
    }

    @DeleteMapping("/products/{id}")
    fun deleteProduct(
        @PathVariable id: Int
    ){
        productRepository.deleteProduct(id)
    }
}