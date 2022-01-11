package c.m.popcorn.presentation.movie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.m.popcorn.domain.use_case.movie.get_last_seen_movies_use_case.GetLastSeenMoviesUseCase
import c.m.popcorn.domain.use_case.movie.get_movie_discover_use_case.GetMovieDiscoverUseCase
import c.m.popcorn.util.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieDiscoverUseCase: GetMovieDiscoverUseCase,
    private val getLastSeenMoviesUseCase: GetLastSeenMoviesUseCase
) : ViewModel() {
    private val _movieListState = mutableStateOf(MovieListState())
    val movieListState: State<MovieListState> = _movieListState

    private val _movieLastSeenState = mutableStateOf(MovieLastSeenListState())
    val movieLastSeenState: State<MovieLastSeenListState> = _movieLastSeenState

    private val _movieIsRefreshState = mutableStateOf(MovieSwipeRefreshState())
    val movieIsRefreshState: State<MovieSwipeRefreshState> = _movieIsRefreshState

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        _movieLastSeenState.value = movieLastSeenState.value.copy(isLoading = true)
        _movieListState.value = movieListState.value.copy(isLoading = true)
    }
}