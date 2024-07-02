package com.example.randomApi

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class RandomRepository(
    private val jdbcTemplate: JdbcTemplate
) {
    fun getAll():List<Random>{
        val list = jdbcTemplate.query("SELECT * FROM random r",RandomMapper())
        return list
    }

    fun generateRandom(
        name: String,
        description: String,
        price: Int,
        quantity: Int
    ){
        jdbcTemplate.execute("INSERT INTO random(name, description, price, quantity) Values(\"$name\", \"$description\", $price, $quantity)")
    }
}