package com.example.mycityapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycityapp.ui.screens.CityAppContent
import com.example.mycityapp.utils.CityContentType

@Composable
fun CityApp(
    windowSize: WindowWidthSizeClass,
){
    val viewModel: CityAppViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> CityContentType.ListOnly

        WindowWidthSizeClass.Expanded -> CityContentType.ListAndDetail
        else -> CityContentType.ListOnly
    }

    Surface{
        CityAppContent(
            contentType = contentType,
            categoryTitle = stringResource(id = uiState.currentPlace.categoryTitleId),
            title = stringResource(id = uiState.currentPlace.titleId),
            subtitle = stringResource(uiState.currentPlace.subtitleId),
            fullDescription = stringResource(uiState.currentPlace.fullDescriptionId),
            imageId = uiState.currentPlace.imageId,
            isShowingListPage = uiState.isShowingListPage,
            categoryList = uiState.places,
            modifier = Modifier.statusBarsPadding().fillMaxSize(),
            onPlaceClick = { selectedPlace ->
                viewModel.cardClick(selectedPlace)
            },
            navigateBack = {
                viewModel.navigateToListPage()
            }
        )
    }
}