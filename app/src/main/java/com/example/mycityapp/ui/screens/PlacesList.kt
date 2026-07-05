package com.example.mycityapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.mycityapp.R
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
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
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
    val spacer = dimensionResource(R.dimen.place_spacer)
    val imageSize = dimensionResource(R.dimen.place_image_size)
    val cardElevation = dimensionResource(R.dimen.card_elevation)


    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(cardElevation)
    ) {
        Row{
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(imageSize)
            )

            Spacer(Modifier.padding(spacer))

            Column{
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(Modifier.padding(spacer))

                Text(
                    text = shortDescription,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}