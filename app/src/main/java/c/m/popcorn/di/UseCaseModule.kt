package c.m.popcorn.di

import c.m.popcorn.domain.repository.movie.MovieRepository
import c.m.popcorn.domain.use_case.movie.get_last_seen_movies_use_case.GetLastSeenMoviesUseCase
import c.m.popcorn.domain.use_case.movie.get_movie_detail_use_case.GetMovieDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetMovieDetailUseCase(movieRepository: MovieRepository): GetMovieDetailUseCase {
        return GetMovieDetailUseCase(movieRepository)
    }

    @Provides
    @Singleton
    fun provideGetLastSeenMovieUseCase(movieRepository: MovieRepository): GetLastSeenMoviesUseCase {
        return GetLastSeenMoviesUseCase(movieRepository)
    }
}