package com.example.mycityapp.ui

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.MyCityData
import com.example.mycityapp.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CityAppViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        CityAppUiState(
            places = MyCityData.getPlaces(),
            currentPlace = MyCityData.getPlaces().getOrElse(0){
                MyCityData.defaultPlaces
            }
        )
    )

    val uiState: StateFlow<CityAppUiState> = _uiState.asStateFlow()

    fun cardClick(selectedPlace: Place){
        _uiState.update { currentState ->
            currentState.copy(
                currentPlace = selectedPlace,
                isShowingListPage = !currentState.isShowingListPage
            )
        }
    }

    fun navigateToListPage(){
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }
}

data class CityAppUiState(
    val places: List<Place> = emptyList(),
    val currentPlace: Place = MyCityData.defaultPlaces,
    val currentPlaceIndex: Int = 0,
    val isShowingListPage: Boolean = true
)

