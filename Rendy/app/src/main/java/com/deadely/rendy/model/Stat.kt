package com.deadely.rendy.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stat(
    @SerializedName("_id") val id: String,
    @SerializedName("date") val date: String,
    @SerializedName("count_tests") val countTests: Int,
    @SerializedName("count_lessons") val countLessons: Int,
) : Parcelable
