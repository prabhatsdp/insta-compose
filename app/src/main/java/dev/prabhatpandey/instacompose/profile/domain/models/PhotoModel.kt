package dev.prabhatpandey.instacompose.profile.domain.models

data class PhotoModel(
    val albumId: Long,
    val id: Long,
    val title: String,
    val url: String,
    val thumbUrl: String
)
