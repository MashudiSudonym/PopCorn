package c.m.popcorn.di

import android.content.Context
import androidx.room.Room
import c.m.popcorn.common.Constants
import c.m.popcorn.data.local.MovieGenresConverters
import c.m.popcorn.data.local.PopCornLocalDatabase
import c.m.popcorn.data.local.movie.MovieDao
import c.m.popcorn.data.util.GsonParser
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun providePopCornLocalDatabase(@ApplicationContext context: Context): PopCornLocalDatabase {
        return Room.databaseBuilder(context, PopCornLocalDatabase::class.java, Constants.POPCORN_DB)
            .addTypeConverter(MovieGenresConverters(GsonParser(Gson())))
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(popCornLocalDatabase: PopCornLocalDatabase): MovieDao {
        return popCornLocalDatabase.movieDao()
    }
}