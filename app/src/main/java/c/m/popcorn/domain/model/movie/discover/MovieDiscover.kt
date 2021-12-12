package c.m.popcorn.domain.model.movie.discover

data class MovieDiscover(
    val page: Int? = 0,
    val results: List<MovieResults>? = emptyList(),
    val totalResult: Int? = 0,
    val totalPages: Int? = 0
)
