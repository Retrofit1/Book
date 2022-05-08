package com.example.novel

import retrofit2.http.GET

interface BookService {
    @GET("book/listClickRank")
    suspend fun getBookList(): BookResponse
}