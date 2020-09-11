package com.example.fortisshisha.models.api

import com.example.fortisshisha.models.Message
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FortisChannelBot {
    @GET("sendMessage?")
    suspend fun sendMessage(
        @Query("chat_id") chat_id: String,
        @Query("text") text: String
    ) : Response<Message>
}
