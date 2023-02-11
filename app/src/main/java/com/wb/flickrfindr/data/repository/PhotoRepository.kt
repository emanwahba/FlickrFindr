package com.wb.flickrfindr.data.repository

import com.wb.flickrfindr.data.remote.model.PhotosApiResponse

interface PhotoRepository {

    suspend fun getPhotos(page: Int?, size: Int?): PhotosApiResponse

    suspend fun searchPhotos(text: String, page: Int?, size: Int?): PhotosApiResponse
}