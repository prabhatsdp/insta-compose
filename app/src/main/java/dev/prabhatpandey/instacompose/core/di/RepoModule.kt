package dev.prabhatpandey.instacompose.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

//    @Binds
//    @Singleton
//    abstract fun bindAuthRepository(repo: AuthRepositoryImpl) : AuthRepository

}
