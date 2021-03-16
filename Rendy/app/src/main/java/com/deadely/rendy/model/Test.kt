package com.deadely.rendy.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Test(
    @SerializedName("_id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("asks") val asks: List<Ask>,
    var isChecked: Boolean = false
) : Parcelable
