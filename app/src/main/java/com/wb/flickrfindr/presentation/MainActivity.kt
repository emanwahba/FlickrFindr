package com.wb.flickrfindr.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wb.flickrfindr.domain.model.Photo
import com.wb.flickrfindr.presentation.photodetails.PhotoDetailsScreen
import com.wb.flickrfindr.presentation.photolist.PhotoListScreen
import com.wb.flickrfindr.presentation.ui.theme.FlickrFindrTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlickrFindrTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.PhotoListScreen.route
                ) {
                    composable(Screen.PhotoListScreen.route) {
                        PhotoListScreen(navController = navController)
                    }
                    composable(
                        route = Screen.PhotoDetailsScreen.route
                    ) {
                        val photo = remember {
                            navController.previousBackStackEntry?.savedStateHandle?.get<Photo>(
                                ScreenParameter.Photo.key
                            ) ?: Photo("", "", "")
                        }
                        PhotoDetailsScreen(
                            photo = photo,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}