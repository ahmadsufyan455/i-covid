package com.fynzero.i_covid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsModel(
    var title: String? = null,
    var url: String? = null
): Parcelable