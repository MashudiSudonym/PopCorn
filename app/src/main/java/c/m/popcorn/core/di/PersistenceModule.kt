package c.m.popcorn.core.di

import android.content.Context
import androidx.room.Room
import c.m.popcorn.core.common.Constants
import c.m.popcorn.movie.data.local.MovieGenresConverters
import c.m.popcorn.core.data.local.PopCornLocalDatabase
import c.m.popcorn.core.data.util.GsonParser
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
}