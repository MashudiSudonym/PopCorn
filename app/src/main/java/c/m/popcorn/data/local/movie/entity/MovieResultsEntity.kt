package c.m.popcorn.data.local.movie.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import c.m.popcorn.domain.model.movie.discover.MovieResults
import c.m.popcorn.domain.model.movie.search.MovieSearchResults

@Entity(tableName = "movie_results")
data class MovieResultsEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "poster_path") val posterPath: String?,
    @ColumnInfo(name = "movie_id") val movieId: String?,
    @ColumnInfo(name = "original_title") val originalTitle: String?,
    @ColumnInfo(name = "original_language") val originalLanguage: String?,
    @ColumnInfo(name = "popularity") val popularity: Double?,
    @ColumnInfo(name = "genre_ids") val genreIds: List<Int>?,
    @ColumnInfo(name = "release_date") val releaseDate: String?,
    @ColumnInfo(name = "vote_average") val voteAverage: Double,
    @ColumnInfo(name = "vote_count") val voteCount: Int?,
    @ColumnInfo(name = "adult") val adult: Boolean?
) {
    fun toMovieResults(): MovieResults {
        return MovieResults(
            posterPath = posterPath,
            id = movieId,
            originalTitle = originalTitle,
            originalLanguage = originalLanguage,
            popularity = popularity,
            genreIds = genreIds,
            releaseDate = releaseDate,
            voteAverage = voteAverage
        )
    }

    fun toMovieSearchResults(): MovieSearchResults {
        return MovieSearchResults(
            posterPath = posterPath,
            id = movieId,
            originalTitle = originalTitle,
            originalLanguage = originalLanguage,
            popularity = popularity,
            genreIds = genreIds,
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            voteCount = voteCount,
            adult = adult
        )
    }
}
