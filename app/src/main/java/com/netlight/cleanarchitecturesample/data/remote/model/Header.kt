package com.netlight.cleanarchitecturesample.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Header(

	@SerializedName("headerTitle")
	val headerTitle: String? = null,
	@SerializedName("headerDescription")
	val headerDescription: String? = null
) : Parcelable