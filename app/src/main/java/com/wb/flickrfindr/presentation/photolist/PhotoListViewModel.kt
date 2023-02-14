package com.wb.flickrfindr.presentation.photolist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wb.flickrfindr.domain.usecase.GetPhotos
import com.wb.flickrfindr.domain.usecase.SearchPhotos
import com.wb.flickrfindr.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

const val PHOTO_PAGE_SIZE = 25

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val getPhotos: GetPhotos,
    private val searchPhotos: SearchPhotos
) : ViewModel() {

    private val _state = mutableStateOf(PhotoListState())
    val state: State<PhotoListState> = _state

    private val _searchTerm = mutableStateOf("")
    val searchTerm: State<String> = _searchTerm

    private val pageNo = 1

    init {
        getPhotos()
    }

    fun getPhotos() {
        _searchTerm.value = ""

        getPhotos(pageNo, PHOTO_PAGE_SIZE).onEach { result ->
            when (result) {
                is NetworkResult.Success -> {
                    _state.value = PhotoListState(photos = result.data?.photoList ?: emptyList())
                }
                is NetworkResult.Error -> {
                    _state.value = PhotoListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is NetworkResult.Loading -> {
                    _state.value = PhotoListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun searchPhotos(text: String) {
        if (text.isBlank()) return

        _searchTerm.value = text

        searchPhotos(text, pageNo, PHOTO_PAGE_SIZE).onEach { result ->
            when (result) {
                is NetworkResult.Success -> {
                    _state.value = PhotoListState(photos = result.data?.photoList ?: emptyList())
                }
                is NetworkResult.Error -> {
                    _state.value = PhotoListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is NetworkResult.Loading -> {
                    _state.value = PhotoListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}