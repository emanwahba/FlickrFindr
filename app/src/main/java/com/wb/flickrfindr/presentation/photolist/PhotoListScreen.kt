package com.wb.flickrfindr.presentation.photolist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wb.flickrfindr.domain.model.Photo
import com.wb.flickrfindr.presentation.Screen
import com.wb.flickrfindr.presentation.ScreenParameter
import com.wb.flickrfindr.presentation.photolist.components.PhotoListItem
import com.wb.flickrfindr.presentation.photolist.components.SearchBar

@Composable
fun PhotoListScreen(
    navController: NavController,
    viewModel: PhotoListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            SearchBar(
                text = viewModel.searchTerm.value,
                hint = "Search...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                when {
                    it.isBlank() -> viewModel.getPhotos()
                    else -> viewModel.searchPhotos(it)
                }
            }
            PhotoGrid(
                photos = state.photos,
                navController = navController
            )
        }

        Box {
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.surface,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .scale(1.5f)
                )
            }
        }
    }
}


@Composable
fun PhotoGrid(
    photos: List<Photo>,
    navController: NavController
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp, top = 8.dp, bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(photos) { photo ->
            PhotoListItem(
                photo = photo,
                onItemClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        ScreenParameter.Photo.key,
                        photo
                    )
                    navController.navigate(Screen.PhotoDetailsScreen.route)
                }
            )
        }
    }
}