package com.example.mycityapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycityapp.R
import com.example.mycityapp.model.Place
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
            onCategoryClick = viewModel::cardClick
        )
    }
}

@Composable
fun CityAppContent(
    contentType: CityContentType,
    categoryTitle: String,
    title: String,
    subtitle: String,
    fullDescription: String,
    @DrawableRes imageId: Int,
    isShowingListPage: Boolean,
    categoryList: List<Place>,
    modifier: Modifier = Modifier,
    onCategoryClick: () -> Unit = {},
){

    Scaffold(
        topBar = {
            CityAppBar(
                categoryTitle = categoryTitle,
                navigateUp = onCategoryClick,
                modifier = Modifier.padding(8.dp)
            )
        },
        modifier = modifier
    ){ innerPadding ->
        if (contentType == CityContentType.ListOnly){
            if (isShowingListPage) {
                CategoryList(
                    categoryList = categoryList,
                    onCategoryClick = onCategoryClick,
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
@Composable
fun CityAppBar(
    categoryTitle: String,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    val iconSize = 30
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "Person",
            modifier = Modifier
                .size(iconSize.dp)
                .clickable { navigateUp() }
        )
        Text(
            text = categoryTitle,
            style = MaterialTheme.typography.titleLarge
        )
    }
}
@Composable
fun CategoryList(
    categoryList: List<Place>,
    onCategoryClick: () -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier){
        items(categoryList.size){
            CategoryCard(
                onClick = onCategoryClick,
                title = stringResource(id = categoryList[it].titleId),
                shortDescription = stringResource(id = categoryList[it].shortDescriptionId),
                imageId = categoryList[it].imageId,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun CategoryCard(
    title: String,
    shortDescription: String,
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
){
    Card(
        onClick = onClick,
        modifier = modifier
    ) {
        Row{
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(128.dp)
            )

            Spacer(Modifier.padding(4.dp))

            Column{
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(Modifier.padding(4.dp))

                Text(
                    text = shortDescription,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun Description (
    title: String,
    subtitle: String,
    fullDescription: String,
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ){
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 400.dp, height = 250.dp)
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )
        Row{
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(Modifier.padding(8.dp))

        Text(
            text = fullDescription,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(2f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun CityAppListOnlyPreview(){
    CityAppContent(
        contentType = CityContentType.ListOnly,
        categoryTitle = "Food",
        title = "National Cuisine Restaurants",
        subtitle = "Downtown Baku",
        fullDescription = "To truly experience Baku, one must dive into its culinary heritage. Scattered across the city—from atmospheric" +
                " stone depots in the Old City to elegant modern venues downtown—these restaurants serve iconic national dishes" +
                ". Here, you can try Shah Plov (royal rice baked in a crispy pastry), tender clay-oven kebabs",
        imageId = R.drawable.foto2_f,
        categoryList = listOf(
            Place(
                categoryTitleId = R.string.category_historical_landmarks,
                titleId = R.string.title1_HL,
                subtitleId = R.string.subtitle1_HL,
                shortDescriptionId = R.string.short_description1_HL,
                fullDescriptionId = R.string.full_description1_HL,
                imageId = R.drawable.foto1_hl
            ),
            Place(
                categoryTitleId = R.string.category_historical_landmarks,
                titleId = R.string.title2_HL,
                subtitleId = R.string.subtitle2_HL,
                shortDescriptionId = R.string.short_description2_HL,
                fullDescriptionId = R.string.full_description2_HL,
                imageId = R.drawable.foto2_hl
            ),
            Place(
                categoryTitleId = R.string.category_historical_landmarks,
                titleId = R.string.title3_HL,
                subtitleId = R.string.subtitle3_HL,
                shortDescriptionId = R.string.short_description3_HL,
                fullDescriptionId = R.string.full_description3_HL,
                imageId = R.drawable.foto3_hl
            ),
            Place(
                categoryTitleId = R.string.category_historical_landmarks,
                titleId = R.string.title4_HL,
                subtitleId = R.string.subtitle4_HL,
                shortDescriptionId = R.string.short_description4_HL,
                fullDescriptionId = R.string.full_description4_HL,
                imageId = R.drawable.foto4_hl
            ),
        ),
        isShowingListPage = true
    )
}

//@Preview(widthDp = 1000)
//@Composable
//fun CityAppListOnlyDetailsPreview(){
//
//}