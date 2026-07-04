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
                isShowingListPage = true,
                isShowingCategoryList = false
            )
        }
    }

    fun selectPlace(selectedPlace: Place){
        _uiState.update { currentState ->
            currentState.copy(
                currentPlace = selectedPlace,
                isShowingListPage = false,
                currentScreen = CityScreen.Details
            )
        }
    }

    fun navigateToPlaceList(){
        _uiState.update {
            it.copy(
                isShowingListPage = true,
                currentScreen = CityScreen.Places,
                currentPlace = null
            )
        }
    }

    fun navigateToCategoryList(){
        _uiState.update {
            it.copy(
                isShowingListPage = false,
                isShowingCategoryList = true,
                currentScreen = CityScreen.Categories,
                currentCategory = null,
                currentPlace = null
            )
        }
    }

}

data class CityAppUiState(
    val categories: List<Category> = emptyList(),
    val currentCategory: Category? = null,
    val currentPlace: Place? = null,
    val currentScreen: CityScreen = CityScreen.Categories,
    val isShowingCategoryList: Boolean = true,
    val isShowingListPage: Boolean = false
)

