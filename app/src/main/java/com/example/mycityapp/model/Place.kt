package com.example.mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place (
    @field:StringRes val categoryTitleId: Int,
    @field:StringRes val titleId: Int,
    @field:StringRes val subtitleId: Int,
    @field:StringRes val shortDescriptionId: Int,
    @field:StringRes val fullDescriptionId: Int,
    @field:DrawableRes val imageId: Int
)

data class Category (
    @field:StringRes val titleId: Int,
    @field:StringRes val shortDescriptionId: Int,
    @field:DrawableRes val imageId: Int,
    val places: List<Place>
)

enum class CityScreen {
    Categories,
    Places,
    Details
}