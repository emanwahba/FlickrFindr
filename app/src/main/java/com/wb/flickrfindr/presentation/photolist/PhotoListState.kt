package com.wb.flickrfindr.presentation.photolist

import com.wb.flickrfindr.domain.model.Photo

data class PhotoListState(
    val isLoading: Boolean = false,
    val photos: List<Photo> = emptyList(),
    val error: String = ""
)