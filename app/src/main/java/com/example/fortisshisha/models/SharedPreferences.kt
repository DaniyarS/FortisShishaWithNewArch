package com.example.fortisshisha.models

import android.content.Context
import android.content.SharedPreferences

const val PREFERENCE = "preference"
const val USER_NAME = "user_name"
const val USER_ADDRESS = "user_address"
const val PHONE_NUMBER = "phone_number"
const val IS_LOGGED = "is_logged"

class SharedPreferences(context: Context?) {

    private val preference: SharedPreferences? =
        context?.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
    private val editor = preference?.edit()

    fun getUserName(): String? {
        return preference?.getString(USER_NAME, "Клиент")
    }

    fun setSetUserName(name: String) {
        editor?.putString(USER_NAME, name)
        editor?.apply()
    }

    fun getAddress(): String? {
        return preference?.getString(USER_ADDRESS, "Ул дом кв")
    }

    fun setAddress(address: String) {
        editor?.putString(USER_ADDRESS, address)
        editor?.apply()
    }

    fun getPhoneNumber(): String? {
        return preference?.getString(PHONE_NUMBER, "87076770047")
    }

    fun setPhoneNumber(phoneNumber: String) {
        editor?.putString(PHONE_NUMBER, phoneNumber)
        editor?.apply()
    }

    fun getLoginCount(): Boolean? {
        return preference?.getBoolean(IS_LOGGED, false)
    }

    fun setLoginCount(value: Boolean) {
        editor?.putBoolean(IS_LOGGED, value)
        editor?.apply()
    }
}