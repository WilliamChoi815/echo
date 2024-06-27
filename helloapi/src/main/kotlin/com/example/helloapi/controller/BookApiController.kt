package com.example.helloapi.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @PatchMapping("/book/{number}")
    fun update(
        @PathVariable number: Int,
        @RequestBody book: Book
    ) {
        for (i in books) {
            if (i.number == number) {
                i.name = book.name
            }
        }
    }

    @DeleteMapping("/book/{number}")
    fun delete(
        @PathVariable number: Int,
    ) {
        books.remove(books.find { it.number == number }!!)
    }

    data class Book(
        val number: Int,
        var name: String,
        val author: String
    )


}