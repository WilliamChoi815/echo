package com.example.helloapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloapiApplication

fun main(args: Array<String>) {
	runApplication<HelloapiApplication>(*args)
}
