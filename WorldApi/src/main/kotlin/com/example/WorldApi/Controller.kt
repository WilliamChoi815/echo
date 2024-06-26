package com.example.WorldApi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class Controller (
    val restTemplate: RestTemplate
){

    @GetMapping("/World")
    fun getWorld(): String {
        val result = restTemplate.getForEntity("http://localhost:8080/hello", String::class.java)
        return "World" + result.body
    }
}