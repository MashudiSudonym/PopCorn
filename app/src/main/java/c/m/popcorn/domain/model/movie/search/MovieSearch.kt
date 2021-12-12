package c.m.popcorn.domain.model.movie.search

data class MovieSearch(
    val page: Int? = 0,
    val results: List<MovieSearchResults>? = emptyList(),
    val totalResult: Int? = 0,
    val totalPages: Int? = 0
)
