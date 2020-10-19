package com.netlight.cleanarchitecturesample.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductResponse(

    @SerializedName("header")
    val header: Header,
    @SerializedName("filters")
    val filters: List<String>,
    @SerializedName("products")
    val products: List<Products>
) : Parcelable