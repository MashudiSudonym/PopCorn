package c.m.popcorn.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import c.m.popcorn.data.local.movie.MovieDao
import c.m.popcorn.data.local.movie.entity.MovieDetailEntity
import c.m.popcorn.data.local.movie.entity.MovieResultsEntity

@Database(
    entities = [MovieDetailEntity::class],
    version = 1
)
abstract class PopCornLocalDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
}