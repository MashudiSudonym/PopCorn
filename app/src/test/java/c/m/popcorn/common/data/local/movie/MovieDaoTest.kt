package c.m.popcorn.common.data.local.movie

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import c.m.popcorn.movie.data.local.MovieLocalDatabase
import c.m.popcorn.movie.data.local.entity.MovieDetailEntity
import c.m.popcorn.common.data.local.util.GsonParser
import c.m.popcorn.movie.data.local.MovieDao
import c.m.popcorn.movie.data.local.MovieGenresConverters
import c.m.popcorn.movie.domain.model.detail.MovieGenres
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
@Config(manifest=Config.NONE)
class MovieDaoTest {

    private lateinit var db: MovieLocalDatabase
    private lateinit var movieDao: MovieDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, MovieLocalDatabase::class.java)
            .allowMainThreadQueries()
            .addTypeConverter(MovieGenresConverters(GsonParser(Gson())))
            .build()
        movieDao = db.movieDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun `write movie detail and read in list`() = runBlocking {
        val movieGenres = MovieGenres(1, "")
        val movieDetail =
            MovieDetailEntity(
                id = 1,
                isFavorite = false,
                backdropPath = "",
                genres = listOf(movieGenres),
                homepage = "",
                movieId = 1,
                imbdId = "",
                originalLanguage = "",
                originalTitle = "",
                overview = "",
                popularity = 1,
                posterPath = "",
                status = "",
                tagline = "",
                voteAverage = 0.0,
                voteCount = 1
            )
        movieDao.insertMovieDetail(movieDetail)
        val getLastSeenMovie = movieDao.getLastSeenMovies()
        assertThat(getLastSeenMovie).contains(movieDetail)
    }

    @Test
    @Throws(Exception::class)
    fun `write movie detail and read single movie id detail`() = runBlocking {
        val movieGenres = MovieGenres(1, "")
        val movieDetail =
            MovieDetailEntity(
                id = 1,
                isFavorite = false,
                backdropPath = "",
                genres = listOf(movieGenres),
                homepage = "",
                movieId = 1,
                imbdId = "",
                originalLanguage = "",
                originalTitle = "",
                overview = "",
                popularity = 1,
                posterPath = "",
                status = "",
                tagline = "",
                voteAverage = 0.0,
                voteCount = 1
            )
        movieDao.insertMovieDetail(movieDetail)
        val getSingleMovieDetail = movieDao.getMovieDetail(1)
        assertThat(getSingleMovieDetail.movieId).isEqualTo(1)
    }
}