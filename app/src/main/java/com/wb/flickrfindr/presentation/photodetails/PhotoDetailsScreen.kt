package com.wb.flickrfindr.presentation.photodetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.wb.flickrfindr.domain.model.Photo

@Composable
fun PhotoDetailsScreen(
    photo: Photo,
    navController: NavController,
) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            TopSection(navController)
            Spacer(modifier = Modifier.padding(24.dp))
            DetailsImage(
                title = photo.title,
                imageUrl = photo.detailImageUrl,
                modifier = Modifier.weight(0.6f)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            DetailsTitle(
                title = photo.title,
                modifier = Modifier.weight(0.4f)
            )
        }
    }
}

@Composable
fun TopSection(
    navController: NavController
) {
    Box(
        contentAlignment = Alignment.TopStart,
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(36.dp)
                .offset(16.dp, 16.dp)
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}

@Composable
fun DetailsImage(
    title: String,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        SubcomposeAsyncImage(model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl).build(),
            contentDescription = title,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxWidth(),
            loading = {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.surface,
                    modifier = Modifier.scale(0.3f)
                )
            })
    }
}

@Composable
fun DetailsTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        fontSize = 26.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 10.dp)
    )
}