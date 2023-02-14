package com.wb.flickrfindr.domain.converter

import com.wb.flickrfindr.data.remote.model.*
import com.wb.flickrfindr.domain.model.Photo
import com.wb.flickrfindr.domain.model.Photos

fun PhotosEntity.toPhotos() = Photos(
    pageNumber = this.page,
    noOfPages = this.pages,
    photoList = this.photoList.map { it.toPhoto() }
)

fun PhotoEntity.toPhoto() = Photo(
    title = title,
    thumbnailUrl = "${PHOTO_BASE_URL}/${server}/${id}_${secret}_${PHOTO_SIZE_THUMBNAIL}.${PHOTO_FORMAT}",
    detailImageUrl = "${PHOTO_BASE_URL}/${server}/${id}_${secret}_${PHOTO_SIZE_LARGE}.${PHOTO_FORMAT}"
)