package com.wb.flickrfindr.domain.converter

import com.wb.flickrfindr.data.remote.model.Photo
import com.wb.flickrfindr.data.remote.model.Photos
import com.wb.flickrfindr.domain.model.PhotoEntity
import com.wb.flickrfindr.domain.model.PhotosEntity

fun Photos.toPhotosEntity() = PhotosEntity(
    pageNumber = this.page,
    noOfPages = this.pages,
    photoList = this.photoList.map { it.toPhotoEntity() }
)

fun Photo.toPhotoEntity() = PhotoEntity(
    photoName = title,
    number = 0, //TODO
    imageUrl = "" //TODO
)