package c.m.popcorn.data.local.movie

import androidx.room.*
import c.m.popcorn.data.local.movie.entity.MovieDetailEntity
import c.m.popcorn.data.local.movie.entity.MovieDiscoverEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    // Movie Discover Queries
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movieDiscover: MovieDiscoverEntity)

    @Query("DELETE FROM movie_discover")
    suspend fun deleteAllMovies()

    @Transaction
    suspend fun updateAllMovies(movieDiscover: MovieDiscoverEntity) {
        deleteAllMovies()
        insertAllMovies(movieDiscover)
    }

    @Query("SELECT * FROM movie_discover")
    suspend fun getAllMovies(): Flow<List<MovieDiscoverEntity>>

    // Movie Detail Queries
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetail(movieDetail: MovieDetailEntity)

    @Query("DELETE FROM movie_detail WHERE movie_id = :movieId")
    suspend fun deleteMovieDetail(movieId: Int)

    @Transaction
    suspend fun updateMovieDetail(movieId: Int, movieDetail: MovieDetailEntity) {
        deleteMovieDetail(movieId)
        insertMovieDetail(movieDetail)
    }

    @Query("SELECT * FROM movie_detail")
    suspend fun getLastSeenMovies(): Flow<List<MovieDetailEntity>>

    @Query("SELECT movie_id FROM movie_detail WHERE movie_id = :movieId")
    suspend fun getMovieDetail(movieId: Int): Flow<MovieDetailEntity>
}