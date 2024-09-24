package com.vipulasri.jetinstagram.data

data class Favorite(
    val id: String,
    val image: String,
    val caption: String,
    val isLiked: Boolean = false
)
