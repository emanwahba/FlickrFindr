package com.wb.flickrfindr.presentation.photolist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.wb.flickrfindr.domain.model.Photo

@Composable
fun PhotoListItem(
    photo: Photo,
    onItemClick: (Photo) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clickable { onItemClick(photo) }
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(
                MaterialTheme.colors.surface
            )
    ) {
        Column {
            ListItemImage(
                title = photo.title,
                imageUrl = photo.thumbnailUrl,
                modifier = Modifier.weight(0.75f)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            ListItemTitle(
                title = photo.title,
                modifier = Modifier.weight(0.25f)
            )
        }
    }
}

@Composable
fun ListItemImage(
    title: String,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        SubcomposeAsyncImage(model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .build(),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            filterQuality = FilterQuality.None,
            modifier = Modifier.fillMaxWidth(),
            loading = {
                CircularProgressIndicator(
                    modifier = Modifier.scale(0.3f)
                )
            })
    }
}

@Composable
fun ListItemTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        maxLines = 1,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 0.dp)
    )
}