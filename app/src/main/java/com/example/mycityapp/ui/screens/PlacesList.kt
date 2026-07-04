package com.example.mycityapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycityapp.model.Place

@Composable
fun PlacesList(
    placesList: List<Place>,
    onPlaceClick: (Place) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier){
        items(placesList.size){
            PlaceCard(
                onClick = {
                    onPlaceClick(placesList[it])
                },
                title = stringResource(id = placesList[it].titleId),
                shortDescription = stringResource(id = placesList[it].shortDescriptionId),
                imageId = placesList[it].imageId,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun PlaceCard(
    title: String,
    shortDescription: String,
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
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