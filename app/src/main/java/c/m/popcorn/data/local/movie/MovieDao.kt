package c.m.popcorn.data.local.movie

import androidx.room.*
import c.m.popcorn.data.local.movie.entity.MovieDetailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieDetail: MovieDetailEntity)

    @Query("DELETE FROM movie_detail WHERE movie_id = :movieId")
    suspend fun deleteMovie(movieId: Int)

    @Transaction
    suspend fun updateMovie(movieId: Int, movieDetail: MovieDetailEntity) {
        deleteMovie(movieId)
        insertMovie(movieDetail)
    }

    @Query("SELECT * FROM movie_detail")
    suspend fun getLastSeenMovies(): Flow<List<MovieDetailEntity>>

    @Query("SELECT movie_id FROM movie_detail WHERE movie_id = :movieId")
    suspend fun getMovie(movieId: Int): Flow<MovieDetailEntity>
}