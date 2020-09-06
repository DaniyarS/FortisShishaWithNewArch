package com.example.fortisshisha.models

import android.content.Context
import android.content.SharedPreferences

const val PREFERENCE = "preference"
const val USER_NAME = "user_name"

class SharedPreferences(context: Context?) {

    private val preference: SharedPreferences? =
        context?.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)

    fun getUserName(): String? {
        return preference?.getString(USER_NAME, "Клиент")
    }

    fun setSetUserName(name: String) {
        val editor = preference?.edit()
        editor?.putString(USER_NAME, name)
        editor?.apply()
    }
}