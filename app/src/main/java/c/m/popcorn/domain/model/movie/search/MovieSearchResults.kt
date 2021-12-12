package c.m.popcorn.domain.model.movie.search

data class MovieSearchResults(
    val posterPath: String? = "",
    val id: String? = "",
    val originalTitle: String? = "",
    val originalLanguage: String? = "",
    val popularity: Double? = 0.0,
    val genreIds: List<Int>? = emptyList(),
    val releaseDate: String? = "",
    val voteAverage: Double? = 0.0,
    val voteCount: Int? = 0,
    val adult: Boolean? = false,
)
