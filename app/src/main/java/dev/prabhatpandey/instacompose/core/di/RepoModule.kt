package dev.prabhatpandey.instacompose.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.prabhatpandey.instacompose.profile.data.repos.PhotosRepositoryImpl
import dev.prabhatpandey.instacompose.profile.domain.repos.PhotosRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(repo: PhotosRepositoryImpl) : PhotosRepository

}
