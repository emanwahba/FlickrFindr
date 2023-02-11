package com.wb.flickrfindr.domain.model

data class PhotosEntity(
    val pageNumber: Int,
    val noOfPages: Int,
    val photoList: List<PhotoEntity>,
)