package c.m.popcorn.movie.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.m.popcorn.core.common.Constants
import c.m.popcorn.core.util.UIEvent
import c.m.popcorn.movie.domain.use_case.get_last_seen_movies_use_case.GetLastSeenMoviesUseCase
import c.m.popcorn.movie.domain.use_case.get_movie_discover_use_case.GetMovieDiscoverUseCase
import c.m.popcorn.movie.presentation.state.MovieDiscoverListState
import c.m.popcorn.movie.presentation.state.MovieLastSeenListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieDiscoverUseCase: GetMovieDiscoverUseCase,
    private val getLastSeenMoviesUseCase: GetLastSeenMoviesUseCase
) : ViewModel() {
    private val _movieLastSeenState = MutableStateFlow(MovieLastSeenListState())
    val movieLastSeenState: StateFlow<MovieLastSeenListState> = _movieLastSeenState.asStateFlow()

    private val _movieDiscoverState = MutableStateFlow(MovieDiscoverListState())
    val movieDiscoverState: StateFlow<MovieDiscoverListState> = _movieDiscoverState

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow: SharedFlow<UIEvent> = _eventFlow.asSharedFlow()

    init {
        getMovieDiscoverListData()
    }

    private fun getMovieDiscoverListData() {
        viewModelScope.launch {
            _movieDiscoverState.update { it.copy(isLoading = true) }
            delay(500L)

            val getMovieDiscoverData = getMovieDiscoverUseCase(
                Constants.TOKEN,
                Constants.STARTING_PAGE_INDEX
            )

            _movieDiscoverState.update { it.copy(isLoading = false) }
            _movieDiscoverState.update { it.copy(movieDiscoverItems = getMovieDiscoverData) }
        }
    }

    fun getLastSeenMovieListData() {

    }

    private fun movieLastSeenListLoadingUpdateState(status: Boolean) {
        _movieLastSeenState.update {
            it.copy(isLoading = false)
        }
    }
}