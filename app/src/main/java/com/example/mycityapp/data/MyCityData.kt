package com.example.mycityapp.data

import com.example.mycityapp.R
import com.example.mycityapp.model.Category
import com.example.mycityapp.model.Place

object MyCityData {
    fun getCategories() = listOf(
        Category(
            titleId = R.string.category_Attractions,
            shortDescriptionId = R.string.short_description_A,
            imageId = R.drawable.attractions,
            places = listOf(
                getPlaces()[0],
                getPlaces()[1],
                getPlaces()[2],
                getPlaces()[3],
            )
        ),
        Category(
            titleId = R.string.category_walks_and_recreation,
            shortDescriptionId = R.string.short_description_WandR,
            imageId = R.drawable.wandr,
            places = listOf(
                getPlaces()[4],
                getPlaces()[5],
                getPlaces()[6],
                getPlaces()[7],
            )
        ),
        Category(
            titleId = R.string.category_food,
            shortDescriptionId = R.string.short_description_f,
            imageId = R.drawable.food,
            places = listOf(
                getPlaces()[8],
                getPlaces()[9],
                getPlaces()[10],
                getPlaces()[11],
            )
        ),
    )

    fun getPlaces() = listOf(
        Place(
            categoryTitleId = R.string.category_Attractions,
            titleId = R.string.title1_A,
            subtitleId = R.string.subtitle1_A,
            shortDescriptionId = R.string.short_description1_A,
            fullDescriptionId = R.string.full_description1_A,
            imageId = R.drawable.photo1_a
        ),
        Place(
            categoryTitleId = R.string.category_Attractions,
            titleId = R.string.title2_A,
            subtitleId = R.string.subtitle2_A,
            shortDescriptionId = R.string.short_description2_A,
            fullDescriptionId = R.string.full_description2_A,
            imageId = R.drawable.photo2_a
        ),
        Place(
            categoryTitleId = R.string.category_Attractions,
            titleId = R.string.title3_A,
            subtitleId = R.string.subtitle3_A,
            shortDescriptionId = R.string.short_description3_A,
            fullDescriptionId = R.string.full_description3_A,
            imageId = R.drawable.photo3_a
        ),
        Place(
            categoryTitleId = R.string.category_Attractions,
            titleId = R.string.title4_A,
            subtitleId = R.string.subtitle4_A,
            shortDescriptionId = R.string.short_description4_A,
            fullDescriptionId = R.string.full_description4_A,
            imageId = R.drawable.photo4_a
        ),
        Place(
            categoryTitleId = R.string.category_walks_and_recreation,
            titleId = R.string.title1_WandR,
            subtitleId = R.string.subtitle1_WandR,
            shortDescriptionId = R.string.short_description1_WandR,
            fullDescriptionId = R.string.full_description1_WandR,
            imageId = R.drawable.photo1_wandr
        ),
        Place(
            categoryTitleId = R.string.category_walks_and_recreation,
            titleId = R.string.title2_WandR,
            subtitleId = R.string.subtitle2_WandR,
            shortDescriptionId = R.string.short_description2_WandR,
            fullDescriptionId = R.string.full_description2_WandR,
            imageId = R.drawable.photo2_wandr
        ),
        Place(
            categoryTitleId = R.string.category_walks_and_recreation,
            titleId = R.string.title3_WandR,
            subtitleId = R.string.subtitle3_WandR,
            shortDescriptionId = R.string.short_description3_WandR,
            fullDescriptionId = R.string.full_description3_WandR,
            imageId = R.drawable.photo3_wandr
        ),
        Place(
            categoryTitleId = R.string.category_walks_and_recreation,
            titleId = R.string.title4_WandR,
            subtitleId = R.string.subtitle4_WandR,
            shortDescriptionId = R.string.short_description4_WandR,
            fullDescriptionId = R.string.full_description4_WandR,
            imageId = R.drawable.photo4_wandr
        ),
        Place(
            categoryTitleId = R.string.category_food,
            titleId = R.string.title1_F,
            subtitleId = R.string.subtitle1_F,
            shortDescriptionId = R.string.short_description1_F,
            fullDescriptionId = R.string.full_description1_F,
            imageId = R.drawable.photo1_f
        ),
        Place(
            categoryTitleId = R.string.category_food,
            titleId = R.string.title2_F,
            subtitleId = R.string.subtitle2_F,
            shortDescriptionId = R.string.short_description2_F,
            fullDescriptionId = R.string.full_description2_F,
            imageId = R.drawable.photo2_f
        ),
        Place(
            categoryTitleId = R.string.category_food,
            titleId = R.string.title3_F,
            subtitleId = R.string.subtitle3_F,
            shortDescriptionId = R.string.short_description3_F,
            fullDescriptionId = R.string.full_description3_F,
            imageId = R.drawable.photo3_f
        ),
        Place(
            categoryTitleId = R.string.category_food,
            titleId = R.string.title4_F,
            subtitleId = R.string.subtitle4_F,
            shortDescriptionId = R.string.short_description4_F,
            fullDescriptionId = R.string.full_description4_F,
            imageId = R.drawable.photo4_f
        ),
    )

    val testPlaces = listOf(
        getPlaces()[0],
        getPlaces()[1],
        getPlaces()[2],
        getPlaces()[3],
    )

    val testCategories = listOf(
        getCategories()[0],
        getCategories()[1],
        getCategories()[2],
    )
}