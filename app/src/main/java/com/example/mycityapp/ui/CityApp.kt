package com.example.mycityapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.R
import com.example.mycityapp.model.CityScreen
import com.example.mycityapp.ui.screens.CityAppContent
import com.example.mycityapp.utils.CityContentType

@Composable
fun CityApp(
    windowSize: WindowWidthSizeClass,
){
    val viewModel: CityAppViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val navController = rememberNavController()

    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> CityContentType.ListOnly

        WindowWidthSizeClass.Expanded -> CityContentType.ListAndDetail
        else -> CityContentType.ListOnly
    }

    Surface{
        CityAppContent(
            contentType = contentType,
            categoryTitle = stringResource(id = uiState.currentCategory?.titleId ?: R.string.default_category_title),
            title = stringResource(id = uiState.currentPlace?.titleId ?: R.string.default_title),
            subtitle = stringResource(id = uiState.currentPlace?.subtitleId ?: R.string.default_subtitle),
            fullDescription = stringResource(id = uiState.currentPlace?.fullDescriptionId ?: R.string.default_full_description),
            imageId = uiState.currentPlace?.imageId ?: R.drawable.foto1_a,
            canNavigateBack = uiState.currentScreen != CityScreen.Categories,
            categoryList = uiState.categories,
            placeList = uiState.currentCategory?.places ?: emptyList(),
            selectIt = {
                viewModel.select(it)
            },
            navigateBack = {
                viewModel.onBackPressed()
                navController.navigateUp()
            },
            navController = navController,
            modifier = Modifier.fillMaxSize()
        )
    }
}