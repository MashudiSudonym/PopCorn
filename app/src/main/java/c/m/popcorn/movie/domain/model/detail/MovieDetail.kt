package c.m.popcorn.movie.domain.model.detail

data class MovieDetail(
    val backdropPath: String? = "",
    val genres: List<MovieGenres>? = emptyList(),
    val homepage: String? = "",
    val id: Int? = 0,
    val imdbId: String? = "",
    val originalLanguage: String? = "",
    val originalTitle: String? = "",
    val overview: String? = "",
    val popularity: Int? = 0,
    val posterPath: String? = "",
    val status: String? = "",
    val tagline: String? = "",
    val voteAverage: Double? = 0.0,
    val voteCount: Int? = 0
)
