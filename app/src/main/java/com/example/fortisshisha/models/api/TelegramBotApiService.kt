package com.example.fortisshisha.models.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.telegram.org/bot1337766282:AAFn7y8isQ5h1ZnO_H-tjR1xLX9CvLk5BZs/"

object TelegramBotApiService {
    fun getTelegramApi(): TelegramBotApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(TelegramBotApiService::class.java)
    }
}