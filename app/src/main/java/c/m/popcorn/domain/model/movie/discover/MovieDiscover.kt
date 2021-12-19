package c.m.popcorn.domain.model.movie.discover

import c.m.popcorn.domain.model.movie.result.MovieResults

data class MovieDiscover(
    val page: Int? = 0,
    val results: List<MovieResults>? = emptyList(),
    val totalResult: Int? = 0,
    val totalPages: Int? = 0
)
