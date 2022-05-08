package com.example.novel

object NovelNetWork {
    private val bookService=ServiceCreator.create<BookService>()
    suspend fun getBookList()= bookService.getBookList()
}