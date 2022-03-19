package c.m.popcorn.movie.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import c.m.popcorn.core.presentation.custom.TextContentTitle
import c.m.popcorn.movie.domain.model.result.MovieResults

@Composable
fun MovieListItems(items: LazyPagingItems<MovieResults>) {
    LazyColumn(
        modifier = Modifier.padding(bottom = 6.dp)
    ) {
        items(items = items) { movieResults ->
            MovieDiscoverItem(movieResults = movieResults as MovieResults)
        }
    }
}

@Composable
fun MovieDiscoverItem(movieResults: MovieResults) {
    Column(modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)) {
        TextContentTitle(title = movieResults.originalTitle ?: "")
    }
}