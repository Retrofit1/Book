package com.example.novel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
     val retrofit: Retrofit =Retrofit.Builder()
        .baseUrl("http:120.26.161.204")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    inline fun <reified T> create():T=retrofit.create(T::class.java)
}