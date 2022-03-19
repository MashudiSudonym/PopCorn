package c.m.popcorn.movie.presentation.state

import androidx.paging.PagingData
import c.m.popcorn.movie.domain.model.result.MovieResults
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MovieDiscoverListState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val movieDiscoverItems: Flow<PagingData<MovieResults>> = emptyFlow()
)
