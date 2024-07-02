package com.example.randomApi

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class RandomMapper: RowMapper<Random> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Random {
        val id = rs.getInt("id")
        val name = rs.getString("name")
        val description = rs.getString("description")
        val price = rs.getInt("price")
        val quantity = rs.getInt("quantity")
        return Random(id,name,description,price,quantity)
    }
}