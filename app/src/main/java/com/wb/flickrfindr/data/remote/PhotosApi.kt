package com.wb.flickrfindr.data.remote

import com.wb.flickrfindr.data.remote.model.PhotosApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

//TODO not production, to be moved to gradle.properties
private const val API_KEY = "1508443e49213ff84d566777dc211f2a"

interface PhotosApi {

    @GET("services/rest/?method=flickr.photos.getRecent&format=json&nojsoncallback=1&api_key=$API_KEY")
    suspend fun getPhotos(
        @Query("page") page: Int?,
        @Query("per_page") size: Int?,
    ): PhotosApiResponse

    @GET("services/rest/?method=flickr.photos.search&format=json&nojsoncallback=1&api_key=$API_KEY")
    suspend fun searchPhotos(
        @Query("text") text: String,
        @Query("page") page: Int?,
        @Query("per_page") size: Int?,
    ): PhotosApiResponse
}