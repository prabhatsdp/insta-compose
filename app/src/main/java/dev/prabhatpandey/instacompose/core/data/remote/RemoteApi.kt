package dev.prabhatpandey.instacompose.core.data.remote

import dev.prabhatpandey.instacompose.profile.data.dtos.PhotoDto
import dev.prabhatpandey.retrofitadapter.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApi {
    @GET(ApiUrls.PHOTOS)
    suspend fun getPhotos(
        @Query(QueryConsts.PAGE) page: Int,
        @Query(QueryConsts.LIMIT) limit: Int
    ) : NetworkResponse<List<PhotoDto>, Any>
}