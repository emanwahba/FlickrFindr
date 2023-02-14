package com.wb.flickrfindr.presentation

sealed class Screen(val route: String) {
    object PhotoListScreen: Screen("photo_list_screen")
    object PhotoDetailsScreen: Screen("photo_detail_screen")
}
