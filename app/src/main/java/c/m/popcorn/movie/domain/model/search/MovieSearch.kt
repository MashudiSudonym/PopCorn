package c.m.popcorn.movie.domain.model.search

import c.m.popcorn.movie.domain.model.result.MovieResults

data class MovieSearch(
    val page: Int? = 0,
    val results: List<MovieResults>? = emptyList(),
    val totalResult: Int? = 0,
    val totalPages: Int? = 0
)
