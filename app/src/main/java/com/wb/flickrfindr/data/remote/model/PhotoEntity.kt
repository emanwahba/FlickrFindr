package com.wb.flickrfindr.data.remote.model

import com.google.gson.annotations.SerializedName

const val PHOTO_BASE_URL = "https://live.staticflickr.com"
const val PHOTO_SIZE_THUMBNAIL = "c"
const val PHOTO_SIZE_LARGE = "b"
const val PHOTO_FORMAT = "jpg"

data class PhotoEntity(
    @SerializedName("farm")
    val farm: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("isfamily")
    val isFamily: Int,
    @SerializedName("isfriend")
    val isFriend: Int,
    @SerializedName("ispublic")
    val isPublic: Int,
    @SerializedName("owner")
    val owner: String,
    @SerializedName("secret")
    val secret: String,
    @SerializedName("server")
    val server: String,
    @SerializedName("title")
    val title: String
)