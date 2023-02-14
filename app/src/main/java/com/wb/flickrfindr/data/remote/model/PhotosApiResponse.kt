package com.wb.flickrfindr.data.remote.model

import com.google.gson.annotations.SerializedName

data class PhotosApiResponse(
    @SerializedName("photos")
    val photosEntity: PhotosEntity,
    @SerializedName("stat")
    val stat: String
)