package c.m.popcorn.presentation.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import c.m.popcorn.R
import c.m.popcorn.presentation.core.custom.DefaultAppBar
import c.m.popcorn.presentation.core.custom.LoadingIndicator
import c.m.popcorn.presentation.core.custom.TextContentTitle
import c.m.popcorn.util.UIEvent
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MovieScreen(title: String?, icon: ImageVector) {
    val movieViewModel: MovieViewModel = hiltViewModel()
    val movieListState by movieViewModel.movieListState.collectAsState()
    val movieLastSeenListState by movieViewModel.movieLastSeenState.collectAsState()
    val movieIsRefreshState by movieViewModel.movieIsRefreshState.collectAsState()
    val scaffoldState = rememberScaffoldState()

    SnackbarLaunchEffect(movieViewModel, scaffoldState)

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            DefaultAppBar(
                title = title ?: stringResource(id = R.string.app_name),
                icon = icon
            )
        },
        modifier = Modifier.fillMaxSize()
    ) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = movieIsRefreshState),
            indicator = { state, refreshTrigger ->
                SwipeRefreshIndicator(
                    state = state,
                    refreshTriggerDistance = refreshTrigger,
                    scale = true,
                    backgroundColor = Color.Transparent
                )
            },
            onRefresh = {
                movieViewModel.isRefreshing()
            }) {
            MovieContents(movieLastSeenListState, movieListState)
        }
    }
}

@Composable
private fun MovieContents(
    movieLastSeenListState: MovieLastSeenListState,
    movieListState: MovieListState
) {
    Box(modifier = Modifier.background(MaterialTheme.colors.background)) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Last Seen Movies
            if (movieLastSeenListState.lastSeenItems.isNotEmpty()) {
                LastSeenMovies(movieLastSeenListState)

                Spacer(modifier = Modifier.height(16.dp))
            }

            // List Movies
            ListMovies(movieListState)
        }
    }
}

@Composable
private fun ListMovies(movieListState: MovieListState) {
    TextContentTitle(title = "List Movies")

    Spacer(modifier = Modifier.height(16.dp))

    if (movieListState.isLoading) {
        LoadingIndicator()
    }
}

@Composable
private fun LastSeenMovies(movieLastSeenListState: MovieLastSeenListState) {
    TextContentTitle(title = "Last Seen Movies")

    Spacer(modifier = Modifier.width(16.dp))

    if (movieLastSeenListState.isLoading) {
        LoadingIndicator()
    }
}

@Composable
private fun SnackbarLaunchEffect(
    movieViewModel: MovieViewModel,
    scaffoldState: ScaffoldState
) {
    LaunchedEffect(key1 = true) {
        movieViewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UIEvent.ShowSnackbar -> scaffoldState.snackbarHostState.showSnackbar(
                    message = event.message
                )
            }
        }
    }
}