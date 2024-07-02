package com.example.randomApi

import kotlin.random.Random
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RandomApiController(
    val repository: RandomRepository
) {

    @GetMapping("/randomList")
    fun getAll(): List<com.example.randomApi.Random> {
        return repository.getAll()
    }


        fun randomString(length: Int): String {
            val chars = 'a'..'z'
            val stringBuilder = StringBuilder()
            repeat(length) {
                stringBuilder.append(chars.random())
            }
            return stringBuilder.toString()
        }


    @GetMapping("/generateList")
    fun makeRandom(): String{

        for (i in 1..1000000){
            repository.generateRandom(randomString(5), randomString(10), Random.nextInt(1,100000), Random.nextInt(1,20))
        }
        return "ok"
    }
}