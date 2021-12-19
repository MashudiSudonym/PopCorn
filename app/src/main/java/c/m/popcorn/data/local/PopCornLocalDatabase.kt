package c.m.popcorn.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import c.m.popcorn.data.local.movie.MovieDao
import c.m.popcorn.data.local.movie.MovieGenresConverters
import c.m.popcorn.data.local.movie.entity.MovieDetailEntity

@Database(
    entities = [MovieDetailEntity::class],
    version = 1
)
@TypeConverters(MovieGenresConverters::class)
abstract class PopCornLocalDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}