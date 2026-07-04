package com.example.mycityapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.data.MyCityData
import com.example.mycityapp.model.Category
import com.example.mycityapp.model.CityScreen
import com.example.mycityapp.model.Place
import com.example.mycityapp.ui.components.CityAppBar
import com.example.mycityapp.utils.CityContentType

@Composable
fun CityAppContent(
    modifier: Modifier = Modifier,
    contentType: CityContentType = CityContentType.ListOnly,
    categoryTitle: String = "",
    title: String = "",
    subtitle: String = "",
    fullDescription: String = "",
    @DrawableRes imageId: Int = 0,
    isShowingCategoryPage: Boolean = true,
    categoryList: List<Category>,
    placeList: List<Place>,
    cityScreen: CityScreen,
    selectCategory: (Category) -> Unit = {},
    selectPlace: (Place) -> Unit = {},
    navigateToCategoryList: () -> Unit = {},
    navigateToPlaceList: () -> Unit = {},
){
    Scaffold(
        topBar = {
            CityAppBar(
                categoryTitle = categoryTitle,
                navigateUp = {
                    if (cityScreen == CityScreen.Places) navigateToCategoryList()
                    else navigateToPlaceList()
                },
                isShowingListPage = isShowingCategoryPage,
                modifier = Modifier.statusBarsPadding().padding(8.dp)
            )
        },
        modifier = modifier
    ){ innerPadding ->
        if (contentType == CityContentType.ListOnly){
            when (cityScreen){
                CityScreen.Categories -> CategoryList(
                    categoryList = categoryList,
                    onCategoryClick = {
                        selectCategory(it)
                    },
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(8.dp)
                )
                CityScreen.Places -> PlacesList(
                    placesList = placeList,
                    onPlaceClick = {
                        selectPlace(it)
                    },
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(8.dp)
                )
                CityScreen.Details -> Description(
                    title = title,
                    subtitle = subtitle,
                    fullDescription = fullDescription,
                    imageId = imageId,
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(8.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun CityAppListOnlyPreview(){
    val viewData = MyCityData
    CityAppContent(
        placeList = viewData.testPlaces,
        isShowingCategoryPage = true,
        categoryList = viewData.testCategories,
        contentType = CityContentType.ListOnly,
        cityScreen = CityScreen.Categories
    )
}