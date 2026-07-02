package com.example.mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Place (
    @StringRes val categoryTitleId: Int,
    @StringRes val titleId: Int,
    @StringRes val subtitleId: Int,
    @StringRes val shortDescriptionId: Int,
    @StringRes val fullDescriptionId: Int,
    @DrawableRes val imageId: Int
)