package com.example.randomApi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RandomApiApplication

fun main(args: Array<String>) {
	runApplication<RandomApiApplication>(*args)
}
