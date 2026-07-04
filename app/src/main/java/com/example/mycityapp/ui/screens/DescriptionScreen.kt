package com.example.mycityapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
