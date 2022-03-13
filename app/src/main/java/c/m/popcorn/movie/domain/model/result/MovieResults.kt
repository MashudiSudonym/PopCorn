package c.m.popcorn.movie.domain.model.result

data class MovieResults(
    val posterPath: String? = "",
    val id: Int? = 0,
    val originalTitle: String? = "",
    val originalLanguage: String? = "",
    val popularity: Double? = 0.0,
    val genreIds: List<Int>? = emptyList(),
    val releaseDate: String? = "",
    val voteAverage: Double? = 0.0
)
