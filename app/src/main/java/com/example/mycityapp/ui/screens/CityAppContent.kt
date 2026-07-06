package com.example.mycityapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.data.MyCityData
import com.example.mycityapp.model.Category
import com.example.mycityapp.model.CityScreen
import com.example.mycityapp.model.Place
import com.example.mycityapp.ui.components.CityAppBar
import com.example.mycityapp.utils.CityContentType
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.dimensionResource
import com.example.mycityapp.R

@Composable
fun CityAppContent(
    modifier: Modifier = Modifier,
    contentType: CityContentType = CityContentType.ListOnly,
    categoryTitle: String = "",
    title: String = "",
    subtitle: String = "",
    fullDescription: String = "",
    @DrawableRes imageId: Int = 0,
    canNavigateBack: Boolean = true,
    categoryList: List<Category>,
    placeList: List<Place>,
    selectCategory: (Category) -> Unit = {},
    selectPlace: (Place) -> Unit = {},
    navigateBack: () -> Unit = {},
    navController: NavHostController = rememberNavController()
){
    val smallPadding = dimensionResource(id = R.dimen.padding_small)

    Scaffold(
        topBar = {
            CityAppBar(
                categoryTitle = categoryTitle,
                navigateUp = navigateBack,
                canNavBack = canNavigateBack,
                modifier = Modifier.statusBarsPadding(),
            )
        },
        modifier = modifier
    ){ innerPadding ->

        if (contentType != CityContentType.ListAndDetail) {
            NavHost(
                navController = navController,
                startDestination = CityScreen.Categories.name,
                modifier = Modifier.padding(innerPadding)
            ){
                composable (route = CityScreen.Categories.name) {
                    CategoryList(
                        categoryList = categoryList,
                        onCategoryClick = {
                            selectCategory(it)
                            navController.navigate(CityScreen.Places.name)
                        },
                        modifier = Modifier.padding(smallPadding)
                    )
                }

                composable (
                    route = CityScreen.Places.name,
                    enterTransition = {
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(350)
                        )
                    },
                    popExitTransition = {
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(350)
                        )
                    }
                ) {
                    PlacesList(
                        placesList = placeList,
                        onPlaceClick = {
                            selectPlace(it)
                            navController.navigate(CityScreen.Details.name)
                        },
                        modifier = Modifier.padding(smallPadding)
                    )
                }

                composable (
                    route = CityScreen.Details.name,
                    enterTransition = {
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(350)
                        )
                    },
                    popExitTransition = {
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(350)
                        )
                    }
                ) {
                    Description(
                        title = title,
                        subtitle = subtitle,
                        fullDescription = fullDescription,
                        imageId = imageId,
                        modifier = Modifier.padding(smallPadding)
                    )
                }
            }
        }
        else {
            NavHost(
                navController = navController,
                startDestination = CityScreen.Categories.name,
                modifier = Modifier.padding(innerPadding)
            ){
                composable (route = CityScreen.Categories.name) {
                    CategoryList(
                        categoryList = categoryList,
                        onCategoryClick = {
                            selectCategory(it)
                            navController.navigate(CityScreen.Places.name)
                        },
                        modifier = Modifier.padding(smallPadding)
                    )
                }

                composable (route = CityScreen.Places.name) {
                    Row{
                        CategoryList(
                            categoryList = categoryList,
                            onCategoryClick = {
                                selectCategory(it)
                                navController.navigate(CityScreen.Places.name)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(smallPadding)
                        )

                        PlacesList(
                            placesList = placeList,
                            onPlaceClick = {
                                selectPlace(it)
                                navController.navigate(CityScreen.Details.name)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(smallPadding)
                        )
                    }
                }

                composable (route = CityScreen.Details.name) {
                    Row {
                        PlacesList(
                            placesList = placeList,
                            onPlaceClick = {
                                selectPlace(it)
                                navController.navigate(CityScreen.Details.name)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(smallPadding)
                        )

                        Description(
                            title = title,
                            subtitle = subtitle,
                            fullDescription = fullDescription,
                            imageId = imageId,
                            modifier = Modifier
                                .weight(1f)
                                .padding(smallPadding)
                        )
                    }
                }
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
        canNavigateBack = false,
        categoryList = viewData.testCategories,
        contentType = CityContentType.ListOnly,
        categoryTitle = "Select a category",
    )
}