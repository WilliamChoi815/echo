package com.example.helloapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloApiController {

    private val persons = mutableListOf<Person>()

    @PostMapping("/person")
    fun addPerson(
        @RequestBody person: Person
    ) {
        println("$person 추가됨.")
        persons.add(person)
    }

    // GET /person 이랑 이름이 겹쳐도 상관없음
    @GetMapping("/person")
    fun getPersons(): List<Person> {
        return persons
    }

    @GetMapping
    fun hello(): String {
        return "Hello"
    }

    @GetMapping("new")
    fun test(): String {
        return "New"
    }

    @GetMapping("parameter")
    fun parameterTest(
        @RequestParam(required = false) age: Int?,
        @RequestParam(required = false) name: String?
    ): String {
        if (age == null && name != null) {
            return name
        }
        if (name == null && age != null) {
            return age.toString()
        }
        return "New$age$name"
    }

    class Person(
        val name: String,
        val age: Int
    ) {
        override fun toString(): String {
            return "$name - $age"
        }
    }
}

