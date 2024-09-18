package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val nameResId: Int,
    val numberOfStudents: Int,
    @DrawableRes val imageResId: Int
)