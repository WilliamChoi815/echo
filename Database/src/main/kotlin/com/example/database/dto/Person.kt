package com.example.database.dto

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

data class Person(
    var id: Int,
    var name: String,
    var age: Int
)

