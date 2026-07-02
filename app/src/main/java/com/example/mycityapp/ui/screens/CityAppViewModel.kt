package com.example.mycityapp.ui.screens

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.MyCityData
import com.example.mycityapp.model.Place
import kotlinx.coroutines.flow.MutableStateFlow

class CityAppViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        CityAppUiState(
            places = MyCityData.getPlaces(),
            currentPlace = MyCityData.getPlaces().getOrElse(0){
                MyCityData.defaultPlaces
            }
        )
    )

    val uiState = _uiState

    fun cardClick(){
        _uiState.value = _uiState.value.copy(isShowingListPage = !uiState.value.isShowingListPage)
    }
}

data class CityAppUiState(
    val places: List<Place> = emptyList(),
    val currentPlace: Place = MyCityData.defaultPlaces,
    val isShowingListPage: Boolean = true
)

