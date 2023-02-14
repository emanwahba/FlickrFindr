package com.wb.flickrfindr.data.remote.model

import com.google.gson.annotations.SerializedName

data class PhotosEntity(
    @SerializedName("page")
    val page: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("perpage")
    val perPage: Int,
    @SerializedName("photo")
    val photoList: List<PhotoEntity>,
    @SerializedName("total")
    val total: String
)