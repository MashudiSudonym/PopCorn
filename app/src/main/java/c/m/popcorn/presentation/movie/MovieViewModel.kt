package c.m.popcorn.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.m.popcorn.domain.use_case.movie.get_last_seen_movies_use_case.GetLastSeenMoviesUseCase
import c.m.popcorn.domain.use_case.movie.get_movie_discover_use_case.GetMovieDiscoverUseCase
import c.m.popcorn.util.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
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