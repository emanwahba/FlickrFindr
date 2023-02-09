package com.wb.flickrfindr.data.remote.model

import com.google.gson.annotations.SerializedName

data class PhotosApiResponse(
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("stat")
    val stat: String
)