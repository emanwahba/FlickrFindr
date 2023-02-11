package com.wb.flickrfindr.data.repository

import com.wb.flickrfindr.data.remote.PhotosApi
import com.wb.flickrfindr.data.remote.model.PhotosApiResponse
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val api: PhotosApi
) : PhotoRepository {

    override suspend fun getPhotos(page: Int?, size: Int?): PhotosApiResponse {
        return api.getPhotos(page, size)
    }

    override suspend fun searchPhotos(text: String, page: Int?, size: Int?): PhotosApiResponse {
        return api.searchPhotos(text, page, size)
    }
}