package com.example.mycityapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.data.MyCityData
import com.example.mycityapp.model.Place
import com.example.mycityapp.ui.components.CategoryList
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
    isShowingListPage: Boolean = true,
    categoryList: List<Place>,
    onPlaceClick: (Place) -> Unit = {},
    navigateBack: () -> Unit = {}
){

    Scaffold(
        topBar = {
            CityAppBar(
                categoryTitle = categoryTitle,
                navigateUp = {
                    navigateBack()
                },
                isShowingListPage = isShowingListPage,
                modifier = Modifier.padding(8.dp)
            )
        },
        modifier = modifier
    ){ innerPadding ->
        if (contentType == CityContentType.ListOnly){
            if (isShowingListPage) {
                CategoryList(
                    categoryList = categoryList,
                    onCategoryClick = { onPlaceClick(it)},
                    modifier = modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                )
            }
            else {
                Description(
                    title = title,
                    subtitle = subtitle,
                    fullDescription = fullDescription,
                    imageId = imageId,
                    modifier = modifier.padding(innerPadding)
                )
            }
        }
        else {
            if (isShowingListPage) {
                CategoryList(
                    categoryList = categoryList,
                    onCategoryClick = { onPlaceClick(it)},
                    modifier = modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                )
            }
            else {
                Description(
                    title = title,
                    subtitle = subtitle,
                    fullDescription = fullDescription,
                    imageId = imageId,
                    modifier = modifier.padding(innerPadding)
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
        categoryList = viewData.testPlaces,
        isShowingListPage = true
    )
}