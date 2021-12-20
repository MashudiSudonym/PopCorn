package c.m.popcorn.di

import c.m.popcorn.data.local.movie.MovieDao
import c.m.popcorn.data.remote.PopCornApi
import c.m.popcorn.data.repository.movie.MovieRepositoryImpl
import c.m.popcorn.domain.repository.movie.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(popCornApi: PopCornApi, movieDao: MovieDao): MovieRepository {
        return MovieRepositoryImpl(popCornApi, movieDao)
    }
}