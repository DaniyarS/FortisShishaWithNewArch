package com.example.fortisshisha.view_model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.fortisshisha.models.Apparat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import kotlin.coroutines.CoroutineContext

class ApparatViewModel (private val context: Context) : ViewModel(), CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    fun generateApparatList() : List<Apparat> {
        val newList: MutableList<Apparat> = ArrayList()

        try {
            val obj = JSONObject(loadJSONFromAsset(context!!))
            val arrayList: JSONArray = obj.getJSONArray("apparats")

            for (i in 0 until arrayList.length()) {
                val ls = Apparat()
                val joInside = arrayList.getJSONObject(i)

                val name = joInside.getString("name")
                val description = joInside.getString("description")
                val price = joInside.getString("price")
                val brandName = joInside.getString("brandName")
                val height = joInside.getString("height")
                val numberOfTube = joInside.getString("numberOfTube")
                val lengthOfTube = joInside.getString("heightOfTube")
                val volumeFlask = joInside.getString("volumeFlask")
                val materialFlask = joInside.getString("materialFlask")
                val materialBowl = joInside.getString("materialBowl")
                val manufacturer = joInside.getString("manufacturer")
                val imgURL = joInside.getString("imgURL")

                ls.name = name
                ls.description = description
                ls.price = price.toFloat()
                ls.brandName = brandName
                ls.height = height
                ls.numberOfTube = numberOfTube
                ls.heightOfTube = lengthOfTube
                ls.volumeFlask = volumeFlask
                ls.materialFlask = materialFlask
                ls.materialBowl = materialBowl
                ls.manufacturer = manufacturer
                ls.imgURL = imgURL

                newList.add(ls)
            }
        } catch (e: Exception) {
            Toast.makeText(context, e.localizedMessage, Toast.LENGTH_SHORT).show()
        }

        return newList
    }

    private fun loadJSONFromAsset(context: Context): String {
        val jsonString: String
        try {
            jsonString = context.assets.open("apparat_data_list.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return "null"
        }
        return jsonString
    }
}