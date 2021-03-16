package com.deadely.rendy.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("_id") val id: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") var password: String,
    @SerializedName("stats") var stats: List<Stat>,
    @SerializedName("active") var active: Boolean,
    @SerializedName("name") val name: String
) : Parcelable
