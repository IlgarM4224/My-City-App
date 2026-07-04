package com.example.mycityapp.data

import com.example.mycityapp.R
import com.example.mycityapp.model.Place

object MyCityData {
    val defaultPlaces = getPlaces()[0]

    fun getPlaces() = listOf(
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
        Place(
            categoryTitleId = R.string.category_walks_and_recreation,
            titleId = R.string.title1_WandR,
            subtitleId = R.string.subtitle1_WandR,
            shortDescriptionId = R.string.short_description1_WandR,
            fullDescriptionId = R.string.full_description1_WandR,
            imageId = R.drawable.foto1_wandr
        ),
        Place(
            categoryTitleId = R.string.category_walks_and_recreation,
            titleId = R.string.title2_WandR,
            subtitleId = R.string.subtitle2_WandR,
            shortDescriptionId = R.string.short_description2_WandR,
            fullDescriptionId = R.string.full_description2_WandR,
            imageId = R.drawable.foto2_wandr
        ),
        Place(
            categoryTitleId = R.string.category_walks_and_recreation,
            titleId = R.string.title3_WandR,
            subtitleId = R.string.subtitle3_WandR,
            shortDescriptionId = R.string.short_description3_WandR,
            fullDescriptionId = R.string.full_description3_WandR,
            imageId = R.drawable.foto3_wandr
        ),
        Place(
            categoryTitleId = R.string.category_walks_and_recreation,
            titleId = R.string.title4_WandR,
            subtitleId = R.string.subtitle4_WandR,
            shortDescriptionId = R.string.short_description4_WandR,
            fullDescriptionId = R.string.full_description4_WandR,
            imageId = R.drawable.foto4_wandr
        ),
        Place(
            categoryTitleId = R.string.category_food,
            titleId = R.string.title1_F,
            subtitleId = R.string.subtitle1_F,
            shortDescriptionId = R.string.short_description1_F,
            fullDescriptionId = R.string.full_description1_F,
            imageId = R.drawable.foto1_f
        ),
        Place(
            categoryTitleId = R.string.category_food,
            titleId = R.string.title2_F,
            subtitleId = R.string.subtitle2_F,
            shortDescriptionId = R.string.short_description2_F,
            fullDescriptionId = R.string.full_description2_F,
            imageId = R.drawable.foto2_f
        ),
        Place(
            categoryTitleId = R.string.category_food,
            titleId = R.string.title3_F,
            subtitleId = R.string.subtitle3_F,
            shortDescriptionId = R.string.short_description3_F,
            fullDescriptionId = R.string.full_description3_F,
            imageId = R.drawable.foto3_f
        ),
        Place(
            categoryTitleId = R.string.category_food,
            titleId = R.string.title4_F,
            subtitleId = R.string.subtitle4_F,
            shortDescriptionId = R.string.short_description4_F,
            fullDescriptionId = R.string.full_description4_F,
            imageId = R.drawable.foto4_f
        ),
    )

    val testPlaces = listOf(
        getPlaces()[0],
        getPlaces()[1],
        getPlaces()[2],
        getPlaces()[3],
    )
}