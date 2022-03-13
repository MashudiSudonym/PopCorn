package c.m.popcorn.movie.presentation

import c.m.popcorn.movie.domain.model.detail.MovieDetail

data class MovieLastSeenListState(
    val lastSeenItems: List<MovieDetail> = emptyList(),
    val isLoading: Boolean = false,
)
