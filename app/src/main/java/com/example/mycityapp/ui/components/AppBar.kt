package com.example.mycityapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CityAppBar(
    modifier: Modifier = Modifier,
    categoryTitle: String,
    navigateUp: () -> Unit,
    isShowingListPage: Boolean = true,
){
    val iconSize = 24
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (!isShowingListPage){
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "Person",
                modifier = Modifier
                    .size(iconSize.dp)
                    .clickable { navigateUp() }
            )
        }
        Text(
            text = categoryTitle,
            style = MaterialTheme.typography.titleLarge
        )
    }
}