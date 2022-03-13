package c.m.popcorn.movie.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import c.m.popcorn.movie.domain.model.result.MovieResults

@Composable
fun ListItems(items: LazyPagingItems<MovieResults>) {
    LazyColumn() {
        items(items = items, key = { movieResults ->
            movieResults.id as Int
        }) { movieResults ->
            movieResults?.let { MovieDiscoverItem(movieResults = it) }
        }
    }
}

@Composable
fun MovieDiscoverItem(movieResults: MovieResults) {

}