package c.m.popcorn.movie.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import c.m.popcorn.core.presentation.custom.TextContentTitle
import c.m.popcorn.movie.domain.model.result.MovieResults
import timber.log.Timber

@Composable
fun MovieListItems(items: LazyPagingItems<MovieResults>) {
    Timber.d(items.itemCount.toString())
    LazyColumn(
        modifier = Modifier
            .background(Color.Magenta)
            .fillMaxSize()
    ) {
        items(items = items) { movieResults ->
            MovieDiscoverItem(movieResults = movieResults as MovieResults)
        }
    }
}

@Composable
fun MovieDiscoverItem(movieResults: MovieResults) {
    TextContentTitle(title = movieResults.originalTitle ?: "")
}