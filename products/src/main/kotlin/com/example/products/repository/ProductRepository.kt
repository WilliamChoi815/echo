package com.example.products.repository

import com.example.products.dto.Product
import com.example.products.repository.mapper.ProductMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Component

@Component
class ProductRepository(
    private val jdbcTemplate: JdbcTemplate
) {
    fun getAll(): List<Product> {
        val list =
            jdbcTemplate.query("SELECT id, description, name, price, stock_quantity FROM product p", ProductMapper())
        return list
    }

    fun getById(
        id: Int
    ):List<Product>{
        val row = jdbcTemplate.query("SELECT * FROM product p WHERE id = $id",ProductMapper())
        return row
    }


    fun createProduct(
        description: String,
        name: String,
        price: Int,
        stockQuantity: Int
    ) {
        jdbcTemplate.execute("INSERT INTO product(description, name, price, stock_quantity) Values(\"$description\",\"$name\",$price,$stockQuantity)")
    }

    fun updateProduct(
        price: Int,
        id: Int
    ) {
        jdbcTemplate.update("UPDATE product SET price = $price WHERE id = $id")
    }

    fun deleteProduct(
        id: Int
    ) {
        jdbcTemplate.execute("DELETE FROM product WHERE id = $id")
    }
}
