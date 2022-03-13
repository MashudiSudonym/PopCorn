package c.m.popcorn.movie.di

import c.m.popcorn.core.data.local.PopCornLocalDatabase
import c.m.popcorn.movie.data.local.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoPersistenceModule {
    @Provides
    @Singleton
    fun provideMovieDao(popCornLocalDatabase: PopCornLocalDatabase): MovieDao {
        return popCornLocalDatabase.movieDao()
    }
}