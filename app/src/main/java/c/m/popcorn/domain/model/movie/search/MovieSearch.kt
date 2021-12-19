package c.m.popcorn.domain.model.movie.search

import c.m.popcorn.domain.model.movie.result.MovieResults

data class MovieSearch(
    val page: Int? = 0,
    val results: List<MovieResults>? = emptyList(),
    val totalResult: Int? = 0,
    val totalPages: Int? = 0
)
