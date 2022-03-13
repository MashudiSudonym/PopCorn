package c.m.popcorn.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import c.m.popcorn.movie.data.local.MovieDao
import c.m.popcorn.movie.data.local.MovieGenresConverters
import c.m.popcorn.movie.data.local.entity.MovieDetailEntity

@Database(
    entities = [MovieDetailEntity::class],
    version = 1
)
@TypeConverters(MovieGenresConverters::class)
abstract class PopCornLocalDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}