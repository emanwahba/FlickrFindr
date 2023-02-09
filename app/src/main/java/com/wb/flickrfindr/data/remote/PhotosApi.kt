package com.wb.flickrfindr.data.remote

import com.wb.flickrfindr.data.remote.model.PhotosApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "1508443e49213ff84d566777dc211f2a"

interface PhotosApi {
    // https://www.flickr.com/services/rest/?method=flickr.photos.getRecent
    // &api_key=1508443e49213ff84d566777dc211f2a&per_page=25&format=json&nojsoncallback=1

    // @GET("services/rest/?method=flickr.photos.getRecent&format=json&nojsoncallback=1&extras=url_s")

    @GET("services/rest/?method=flickr.photos.getRecent&format=json&nojsoncallback=1&api_key=$API_KEY")
    suspend fun getPhotos(
        @Query("page") page: Int?,
        @Query("per_page") size: Int?,
    ): PhotosApiResponse

    // https://www.flickr.com/services/rest/?method=flickr.photos.search
    // &api_key=1508443e49213ff84d566777dc211f2a&text=apple&per_page=25&page=1&format=json&nojsoncallback=1

    @GET("services/rest/?method=flickr.photos.search&format=json&nojsoncallback=1&api_key=$API_KEY")
    suspend fun searchPhotos(
        @Query("text") text: String,
        @Query("page") page: Int?,
        @Query("per_page") size: Int?,
    ): PhotosApiResponse
}