package com.example.fortisshisha.view_model

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.fortisshisha.models.MainMenuCategory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class MainMenuViewModel (private val context: Context) : ViewModel(), CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val menuList = listOf(
        MainMenuCategory(1, "КАЛЬЯНЫ"),
        MainMenuCategory(2, "ТАБАК"),
        MainMenuCategory(3, "УГЛИ"),
        MainMenuCategory(4, "КАЛЬЯН С ЗАБИВКОЙ")
    )

    fun getMenuList(): List<MainMenuCategory> {
        return menuList
    }
}