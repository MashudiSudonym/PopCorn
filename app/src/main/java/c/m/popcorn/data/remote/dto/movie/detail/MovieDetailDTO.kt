package c.m.popcorn.data.remote.dto.movie.detail

import c.m.popcorn.data.local.movie.entity.MovieDetailEntity
import com.google.gson.annotations.SerializedName

data class MovieDetailDTO(
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("backdrop_path")
    val backdropPath: String? = "",
    @SerializedName("belongs_to_collection")
    val belongsToCollection: MovieBelongsToCollectionDTO = MovieBelongsToCollectionDTO(),
    @SerializedName("budget")
    val budget: Int? = 0,
    @SerializedName("genres")
    val genres: List<MovieGenresDTO>? = emptyList(),
    @SerializedName("homepage")
    val homepage: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("imdb_id")
    val imdbId: String? = "",
    @SerializedName("original_language")
    val originalLanguage: String? = "",
    @SerializedName("original_title")
    val originalTitle: String? = "",
    @SerializedName("overview")
    val overview: String? = "",
    @SerializedName("popularity")
    val popularity: Int? = 0,
    @SerializedName("poster_path")
    val posterPath: String? = "",
    @SerializedName("production_companies")
    val productionCompanies: List<MovieProductionCompaniesDTO>? = emptyList(),
    @SerializedName("production_countries")
    val productionCountries: List<MovieProductionCountriesDTO>? = emptyList(),
    @SerializedName("release_date")
    val releaseDate: String? = "",
    @SerializedName("revenue")
    val revenue: Int? = 0,
    @SerializedName("runtime")
    val runtime: Int? = 0,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<MovieSpokenLanguagesDTO>? = emptyList(),
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("tagline")
    val tagline: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("video")
    val video: Boolean = false,
    @SerializedName("vote_average")
    val voteAverage: Double? = 0.0,
    @SerializedName("vote_count")
    val voteCount: Int? = 0
) {
    fun toMovieDetailEntity(): MovieDetailEntity {
        return MovieDetailEntity(
            backdropPath = backdropPath,
            genres = genres?.map { it.toMovieGenres() },
            homepage = homepage,
            movieId = id,
            imbdId = imdbId,
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
