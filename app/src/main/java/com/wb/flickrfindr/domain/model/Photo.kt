package com.wb.flickrfindr.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photo(
    val title: String,
    val thumbnailUrl: String,
    val detailImageUrl: String
) : Parcelable