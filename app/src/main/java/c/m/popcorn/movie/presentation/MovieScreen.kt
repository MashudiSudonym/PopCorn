package c.m.popcorn.movie.presentation

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import c.m.popcorn.R
import c.m.popcorn.core.presentation.custom.DefaultAppBar
import c.m.popcorn.core.presentation.custom.LoadingIndicator
import c.m.popcorn.core.presentation.custom.TextContentTitle
import c.m.popcorn.core.util.UIEvent
import c.m.popcorn.movie.presentation.state.MovieDiscoverListState
import c.m.popcorn.movie.presentation.state.MovieLastSeenListState
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MovieScreen(title: String?, icon: ImageVector) {
    val movieViewModel: MovieViewModel = hiltViewModel()
    val movieDiscoverListState by movieViewModel.movieDiscoverState.collectAsState()
    val movieLastSeenListState by movieViewModel.movieLastSeenState.collectAsState()

    Scaffold(
        topBar = {
            DefaultAppBar(
                title = title ?: stringResource(id = R.string.app_name),
                icon = icon
            )
        },
        modifier = Modifier.padding(bottom = 56.dp)
    ) {
        MovieContents(movieLastSeenListState, movieDiscoverListState)
    }
}

@Composable
private fun MovieContents(
    movieLastSeenListState: MovieLastSeenListState,
    movieDiscoverListState: MovieDiscoverListState
) {
    Box(modifier = Modifier
        .background(MaterialTheme.colors.background)) {
        Column(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Last Seen Movies
            if (movieLastSeenListState.lastSeenItems.isNotEmpty()) {
                LastSeenMovies(movieLastSeenListState)

                Spacer(modifier = Modifier.height(16.dp))
            }

            // List Movies
            DiscoverMovies(movieDiscoverListState)
        }
    }
}

@Composable
private fun DiscoverMovies(movieDiscoverListState: MovieDiscoverListState) {
    TextContentTitle(title = "List Movies")

    Spacer(modifier = Modifier.height(16.dp))

    val movieDiscoverItems = movieDiscoverListState.movieDiscoverItems.collectAsLazyPagingItems()

    when {
        movieDiscoverListState.isLoading -> LoadingIndicator()
        movieDiscoverListState.isError -> TextContentTitle(title = "Error")
        movieDiscoverItems.itemCount == 0 -> TextContentTitle(title = "No Data")
        else -> MovieListItems(items = movieDiscoverItems)
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