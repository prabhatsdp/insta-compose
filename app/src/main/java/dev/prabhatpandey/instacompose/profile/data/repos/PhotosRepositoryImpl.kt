package dev.prabhatpandey.instacompose.profile.data.repos

import dev.prabhatpandey.instacompose.core.data.remote.RemoteApi
import dev.prabhatpandey.instacompose.core.utils.extensions.toDomainError
import dev.prabhatpandey.instacompose.profile.domain.models.PhotoModel
import dev.prabhatpandey.instacompose.profile.domain.repos.PhotosRepository
import dev.prabhatpandey.retrofitadapter.NetworkResponse
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotosRepositoryImpl @Inject constructor(
    private val api: RemoteApi
): PhotosRepository {
    override suspend fun getPhotos(page: Int, limit: Int): Result<List<PhotoModel>> {
        return try {
            when(val result = api.getPhotos(page, limit)) {
                is NetworkResponse.Success -> {
                    Result.success(result.body.map { it.asDomainModel() })
                }
                else -> {
                    Result.failure(result.toDomainError())
                }
            }
        } catch (e: Exception) {
            Timber.e(e, "getPhotos: ${e.message}")
            Result.failure(e)
        }
    }
}