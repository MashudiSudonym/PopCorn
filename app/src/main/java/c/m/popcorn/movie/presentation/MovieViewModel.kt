package c.m.popcorn.movie.presentation

import androidx.lifecycle.ViewModel
import c.m.popcorn.movie.domain.use_case.get_last_seen_movies_use_case.GetLastSeenMoviesUseCase
import c.m.popcorn.movie.domain.use_case.get_movie_discover_use_case.GetMovieDiscoverUseCase
import c.m.popcorn.core.util.UIEvent
import c.m.popcorn.movie.presentation.state.MovieLastSeenListState
import c.m.popcorn.movie.presentation.state.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieDiscoverUseCase: GetMovieDiscoverUseCase,
    private val getLastSeenMoviesUseCase: GetLastSeenMoviesUseCase
) : ViewModel() {
    private val _movieListState = MutableStateFlow(MovieListState())
    val movieListState: StateFlow<MovieListState> = _movieListState.asStateFlow()

    private val _movieLastSeenState = MutableStateFlow(MovieLastSeenListState())
    val movieLastSeenState: StateFlow<MovieLastSeenListState> = _movieLastSeenState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow: SharedFlow<UIEvent> = _eventFlow.asSharedFlow()

    init {

    }

    fun getMovieDiscoverListData() {

    }

    fun getLastSeenMovieListData() {

    }

    private fun movieListLoadingUpdateState(status: Boolean) {
        _movieListState.update {
            it.copy(isLoading = false)
        }
    }

    private fun movieLastSeenListLoadingUpdateState(status: Boolean) {
        _movieLastSeenState.update {
            it.copy(isLoading = false)
        }
    }
}