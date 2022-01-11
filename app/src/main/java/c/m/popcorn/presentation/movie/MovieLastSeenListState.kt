package c.m.popcorn.presentation.movie

import c.m.popcorn.domain.model.movie.detail.MovieDetail

data class MovieLastSeenListState(
    val lastSeenItems: List<MovieDetail> = emptyList(),
    val isLoading: Boolean = false,
)
