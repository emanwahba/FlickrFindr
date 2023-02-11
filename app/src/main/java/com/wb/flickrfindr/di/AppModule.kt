package com.wb.flickrfindr.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wb.flickrfindr.data.remote.PhotosApi
import com.wb.flickrfindr.data.repository.PhotosRepository
import com.wb.flickrfindr.data.repository.PhotosRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePhotosRepository(api: PhotosApi): PhotosRepository = PhotosRepositoryImpl(api)

    @Singleton
    @Provides
    fun providePhotosApi(retrofit: Retrofit): PhotosApi = retrofit.create(PhotosApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit = Retrofit.Builder()
        .baseUrl("https://www.flickr.com/")
        .addConverterFactory(gsonConverterFactory)
        .build()

    @Singleton
    @Provides
    fun provideConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()
}