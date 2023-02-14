package com.wb.flickrfindr.domain.usecase

import com.wb.flickrfindr.data.repository.PhotosRepository
import com.wb.flickrfindr.domain.converter.toPhotos
import com.wb.flickrfindr.domain.model.Photos
import com.wb.flickrfindr.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchPhotos @Inject constructor(
    private val repository: PhotosRepository
) {
    operator fun invoke(
        text: String,
        page: Int?,
        size: Int?
    ): Flow<NetworkResult<Photos>> = flow {
        try {
            emit(NetworkResult.Loading())
            val photosEntity =
                repository.searchPhotos(text, page, size)
                    .photosEntity
                    .toPhotos()
            emit(NetworkResult.Success(photosEntity))
        } catch (e: HttpException) {
            emit(NetworkResult.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(NetworkResult.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}