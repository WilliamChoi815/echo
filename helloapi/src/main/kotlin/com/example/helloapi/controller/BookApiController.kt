package com.example.helloapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.awt.print.Book
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private

@RestController
class BookApiController {
    private val books = mutableListOf<Book>()

    @PostMapping("/book")
    fun addBook(
        @RequestBody book: Book
    ) {
        books.add(book)
    }

    @GetMapping("/book")
    fun getBooks(): List<Book> {
        return books
    }

    class Book(
        private val number: Int,
        private val name: String,
        private val author: String
    ) {
        override fun toString(): String {
            return "$number - $name - $author"
        }
    }
}