package com.example.mycityapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.data.MyCityData
import com.example.mycityapp.model.Category

@Composable
fun CategoryList(
    categoryList: List<Category>,
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier){
        items(categoryList.size){
            PlaceCard(
                title = stringResource(id = categoryList[it].titleId),
                shortDescription = stringResource(id = categoryList[it].shortDescriptionId),
                imageId = categoryList[it].imageId,
                onClick = {
                    onCategoryClick(categoryList[it])
                },
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryListPreview(){
    val viewData = MyCityData.testCategories
    CategoryList(
        categoryList = viewData,
        onCategoryClick = {},
        modifier = Modifier.padding(8.dp)
    )
}