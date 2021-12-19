package c.m.popcorn.data.local.movie

import androidx.room.*
import c.m.popcorn.data.local.movie.entity.MovieDetailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
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
    suspend fun getLastSeenMovies(): List<MovieDetailEntity>

    @Query("SELECT movie_id FROM movie_detail WHERE movie_id = :movieId")
    suspend fun getMovieDetail(movieId: Int): MovieDetailEntity
}