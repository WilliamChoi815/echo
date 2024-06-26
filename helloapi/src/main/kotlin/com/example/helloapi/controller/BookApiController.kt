package com.example.helloapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookApiController {
    private val books = mutableListOf<Book>()

    @PostMapping("/book")
    fun addBook(
        @RequestBody book: Book
    ) {
        println(book)
        books.add(book)
    }

    @GetMapping("/book")
    fun getBooks(): List<Book> {
        return books
    }

    data class Book(
        val number: Int,
        val name: String,
        val author: String
    )


}