package com.example.mycityapp.ui

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.MyCityData
import com.example.mycityapp.model.Category
import com.example.mycityapp.model.CityScreen
import com.example.mycityapp.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CityAppViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        CityAppUiState(
            categories = MyCityData.getCategories(),
        )
    )

    val uiState: StateFlow<CityAppUiState> = _uiState.asStateFlow()

    fun selectCategory(selectedCategory: Category){
        _uiState.update { currentCategory ->
            currentCategory.copy(
                currentCategory = selectedCategory,
                currentScreen = CityScreen.Places,
            )
        }
    }

    fun selectPlace(selectedPlace: Place){
        _uiState.update { currentState ->
            currentState.copy(
                currentPlace = selectedPlace,
                currentScreen = CityScreen.Details
            )
        }
    }

    fun onBackPressed(){
        when (uiState.value.currentScreen){
            CityScreen.Details -> {
                _uiState.update { currentState ->
                    currentState.copy(
                        currentScreen = CityScreen.Places,
                        currentPlace = null
                    )
                }
            }
            CityScreen.Places -> {
                _uiState.update { currentState ->
                    currentState.copy(
                        currentScreen = CityScreen.Categories,
                        currentCategory = null
                    )
                }
            }
            else -> { }
        }
    }
}

data class CityAppUiState(
    val categories: List<Category> = emptyList(),
    val currentCategory: Category? = null,
    val currentPlace: Place? = null,
    val currentScreen: CityScreen = CityScreen.Categories,
)

