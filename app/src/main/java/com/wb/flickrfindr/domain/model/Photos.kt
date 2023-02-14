package com.wb.flickrfindr.domain.model

data class Photos(
    val pageNumber: Int,
    val noOfPages: Int,
    val photoList: List<Photo>,
)