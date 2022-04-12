package c.m.popcorn.movie.di

import c.m.popcorn.movie.data.local.MovieDao
import c.m.popcorn.movie.data.remote.MoviePopCornApi
import c.m.popcorn.movie.data.repository.MovieRepositoryImpl
import c.m.popcorn.movie.domain.repository.MovieRepository
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
    fun provideMovieRepository(moviePopCornApi: MoviePopCornApi, movieDao: MovieDao): MovieRepository {
        return MovieRepositoryImpl(moviePopCornApi, movieDao)
    }
}