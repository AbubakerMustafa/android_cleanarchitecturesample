package com.netlight.cleanarchitecturesample.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price(

    @SerializedName("value")
    val value: Double?,
    @SerializedName("currency")
    val currency: String?
) : Parcelable