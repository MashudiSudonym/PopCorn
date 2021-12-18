package c.m.popcorn.data.local.movie.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import c.m.popcorn.domain.model.movie.detail.MovieDetail
import c.m.popcorn.domain.model.movie.detail.MovieGenres

@Entity(tableName = "movie_detail")
data class MovieDetailEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Long = 0L,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean = false,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "genres")
    val genres: List<MovieGenres>?,
    @ColumnInfo(name = "homepage")
    val homepage: String?,
    @ColumnInfo(name = "movie_id")
    val movieId: Int?,
    @ColumnInfo(name = "imdb_id")
    val imbdId: String?,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String?,
    @ColumnInfo(name = "original_title")
    val originalTitle: String?,
    @ColumnInfo(name = "overview")
    val overview: String?,
    @ColumnInfo(name = "popularity")
    val popularity: Int?,
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
    @ColumnInfo(name = "status")
    val status: String?,
    @ColumnInfo(name = "tagline")
    val tagline: String?,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double?,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int?
) {
    fun toMovieDetail(): MovieDetail {
        return MovieDetail(
            backdropPath = backdropPath,
            genres = genres,
            homepage = homepage,
            id = movieId,
            imdbId = imbdId,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath,
            status = status,
            tagline = tagline,
            voteAverage = voteAverage,
            voteCount = voteCount
        )
    }
}
