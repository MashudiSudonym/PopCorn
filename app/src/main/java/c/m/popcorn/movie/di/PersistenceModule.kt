package c.m.popcorn.movie.di

import android.content.Context
import androidx.room.Room
import c.m.popcorn.common.util.Constants
import c.m.popcorn.movie.data.local.MovieGenresConverters
import c.m.popcorn.movie.data.local.MovieLocalDatabase
import c.m.popcorn.common.data.local.util.GsonParser
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
    fun provideMoviePopCornLocalDatabase(@ApplicationContext context: Context): MovieLocalDatabase {
        return Room.databaseBuilder(context, MovieLocalDatabase::class.java, Constants.POPCORN_DB)
            .addTypeConverter(MovieGenresConverters(GsonParser(Gson())))
            .fallbackToDestructiveMigration()
            .build()
    }
}