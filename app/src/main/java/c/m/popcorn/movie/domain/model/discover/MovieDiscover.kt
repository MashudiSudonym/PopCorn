package c.m.popcorn.movie.domain.model.discover

import c.m.popcorn.movie.domain.model.result.MovieResults

data class MovieDiscover(
    val page: Int? = 0,
    val results: List<MovieResults>? = emptyList(),
    val totalResult: Int? = 0,
    val totalPages: Int? = 0
)
