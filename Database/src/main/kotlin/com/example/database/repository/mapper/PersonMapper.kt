package com.example.database.repository.mapper

import com.example.database.dto.Person
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class PersonMapper : RowMapper<Person> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Person {
        val id = rs.getInt("id")
        val name = rs.getString("name")
        val age = rs.getInt("age")
        return Person(id, name, age)
    }
}