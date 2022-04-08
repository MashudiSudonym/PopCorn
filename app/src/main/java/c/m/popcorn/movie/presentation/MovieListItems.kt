package c.m.popcorn.movie.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import c.m.popcorn.R
import c.m.popcorn.core.common.Constants
import c.m.popcorn.core.presentation.custom.TextContentTitle
import c.m.popcorn.movie.domain.model.result.MovieResults
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MovieListItems(items: LazyPagingItems<MovieResults>) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier.padding(bottom = 6.dp),
    ) {
        items(items = items) { movieResults ->
            MovieDiscoverItem(movieResults = movieResults as MovieResults)
        }
    }
}

@Composable
fun MovieDiscoverItem(movieResults: MovieResults) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 2.dp,
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        CoilImage(
            modifier = Modifier
                .size(240.dp),
            imageModel = "${Constants.BASE_URL_IMAGE}${movieResults.posterPath}",
            contentScale = ContentScale.Crop,
            circularReveal = CircularReveal(duration = 350),
            placeHolder = ImageBitmap.imageResource(R.mipmap.ic_launcher_foreground),
            error = ImageVector.vectorResource(R.drawable.ic_baseline_warning_24),
        )
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.size(248.dp))
            TextContentTitle(title = movieResults.originalTitle ?: Constants.IS_BLANK)
            Text(text = movieResults.releaseDate ?: Constants.IS_BLANK)
        }
    }
}