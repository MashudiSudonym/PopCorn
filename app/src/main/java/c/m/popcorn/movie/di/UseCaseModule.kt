package c.m.popcorn.movie.di

import c.m.popcorn.movie.domain.repository.MovieRepository
import c.m.popcorn.movie.domain.use_case.get_last_seen_movies_use_case.GetLastSeenMoviesUseCase
import c.m.popcorn.movie.domain.use_case.get_movie_detail_use_case.GetMovieDetailUseCase
import c.m.popcorn.movie.domain.use_case.get_movie_discover_use_case.GetMovieDiscoverUseCase
import c.m.popcorn.movie.domain.use_case.get_search_movies_use_case.GetSearchMoviesUseCase
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

    @Provides
    @Singleton
    fun provideGetMovieDiscoverUseCase(movieRepository: MovieRepository): GetMovieDiscoverUseCase {
        return GetMovieDiscoverUseCase(movieRepository)
    }

    @Provides
    @Singleton
    fun provideGetSearchMoviesUseCase(movieRepository: MovieRepository): GetSearchMoviesUseCase {
        return GetSearchMoviesUseCase(movieRepository)
    }
}