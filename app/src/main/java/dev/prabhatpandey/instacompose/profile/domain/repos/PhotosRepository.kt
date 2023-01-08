package dev.prabhatpandey.instacompose.profile.domain.repos

import dev.prabhatpandey.instacompose.profile.domain.models.PhotoModel

interface PhotosRepository {
    suspend fun getPhotos(
        page: Int = 1,
        limit: Int = 10
    ) : Result<List<PhotoModel>>
}