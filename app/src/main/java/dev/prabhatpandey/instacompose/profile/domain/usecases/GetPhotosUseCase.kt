package dev.prabhatpandey.instacompose.profile.domain.usecases

import dagger.hilt.android.scopes.ViewModelScoped
import dev.prabhatpandey.instacompose.profile.domain.models.PhotoModel
import dev.prabhatpandey.instacompose.profile.domain.repos.PhotosRepository
import javax.inject.Inject

@ViewModelScoped
class GetPhotosUseCase @Inject constructor(
    private val repo: PhotosRepository
) {
    suspend operator fun invoke(): Result<List<PhotoModel>> {
        return repo.getPhotos(1, 10)
    }
}