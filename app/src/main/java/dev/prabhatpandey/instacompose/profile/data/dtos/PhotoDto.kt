package dev.prabhatpandey.instacompose.profile.data.dtos


import com.google.gson.annotations.SerializedName
import dev.prabhatpandey.instacompose.profile.domain.models.PhotoModel

data class PhotoDto(
    @SerializedName("albumId")
    val albumId: Long,
    @SerializedName("id")
    val id: Long,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
) {
    fun asDomainModel(): PhotoModel {
        return PhotoModel(
            albumId = albumId,
            id = id,
            title = title,
            url = url,
            thumbUrl = thumbnailUrl
        )
    }
}