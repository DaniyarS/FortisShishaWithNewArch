package com.example.fortisshisha.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("text")
    @Expose
    val message: String? = null
)