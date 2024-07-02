package com.example.products.repository.mapper

import com.example.products.dto.Product
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class ProductMapper: RowMapper<Product> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Product {
        val id = rs.getInt("id")
        val description = rs.getString("description")
        val name = rs.getString("name")
        val price = rs.getInt("price")
        val stockQuantity = rs.getInt("stock_quantity")
        return Product(id, description, name, price, stockQuantity)
    }
}