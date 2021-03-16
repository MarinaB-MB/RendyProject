package com.deadely.rendy.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Word(
    @SerializedName("_id") val id: String,
    @SerializedName("word") val text: String,
    @SerializedName("translate") val translate: String,
    @SerializedName("tr") val transcription: String,
    var isFavorite: Boolean = false
) : Parcelable
