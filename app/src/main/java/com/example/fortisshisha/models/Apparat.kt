package com.example.fortisshisha.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Apparat(
    var name: String? = null,
    var description: String? = null,
    var price: Float? = null,
    var brandName: String? = null,
    var height: String? = null,
    var numberOfTube: String? = null,
    var heightOfTube: String? = null,
    var volumeFlask: String? = null,
    var materialFlask: String? = null,
    var materialBowl: String? = null,
    var manufacturer: String? = null,
    var imgURL: String? = null
) : Parcelable