package com.example.database.repository

import com.example.database.dto.Person
import com.example.database.repository.mapper.PersonMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class PersonRepository(
    private val jdbcTemplate: JdbcTemplate
) {
    fun getAll(): List<Person> {
        val list = jdbcTemplate.query("SELECT id, name, age FROM person p", PersonMapper())
        list.forEach {
            println(it)
        }
        return list
    }

    /**
     * Person 객체를 생성하고 db에 저장한다.
     * @param name 사람의 이름
     * @param age 사람의 나이
     */
    fun createPerson(
        name: String, age: Int
    ) {
        jdbcTemplate.execute("INSERT INTO person(name, age) Values(\"$name\", $age)")

    }

    fun updatePerson(
        ageReplace: Int, ageCompare: Int
    ) {
        jdbcTemplate.update("UPDATE person SET age = $ageReplace WHERE age > $ageCompare")
    }

    fun deletePerson(
        id: Int
    ) {
        jdbcTemplate.execute("DELETE FROM person WHERE id = $id")
    }

}