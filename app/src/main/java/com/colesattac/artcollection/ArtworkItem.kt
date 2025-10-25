package com.colesattac.artcollection

import androidx.annotation.DrawableRes

data class ArtworkItem(
    val title: String, // название произведения
    @DrawableRes val imageResId: Int, // ID ресурса изображения из drawable
    val author: String, // автор произведения
    val year: String, // год создания (используем String для гибкости)
    val detailedInfo: String // описание
)
