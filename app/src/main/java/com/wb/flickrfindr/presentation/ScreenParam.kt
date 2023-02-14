package com.wb.flickrfindr.presentation

sealed class ScreenParameter(val key: String) {
    object Photo: ScreenParameter("photo")
}
