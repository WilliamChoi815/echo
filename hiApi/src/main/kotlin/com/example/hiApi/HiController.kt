package com.example.hiApi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@RestController
class HiController (
    val restTemplate: RestTemplate
){

    @GetMapping("/Hi")
    fun getHi(): String{
        val result = restTemplate.getForEntity("http://localhost:8081/World", String::class.java)
        return "Hi" + result.body
    }
}