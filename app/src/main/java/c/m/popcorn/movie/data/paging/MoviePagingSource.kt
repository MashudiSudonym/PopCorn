package c.m.popcorn.movie.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import c.m.popcorn.movie.data.remote.MoviePopCornApi
import c.m.popcorn.movie.domain.model.result.MovieResults

class MoviePagingSource(
    private val moviePopCornApi: MoviePopCornApi,
    private val token: String
) :
    PagingSource<Int, MovieResults>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResults> {
        return try {
            val position = params.key ?: 1
            val response = moviePopCornApi.movieDiscover(token, position).toMovieDiscover()
            val nextKey = if (response.results.orEmpty().isEmpty()) {
                null
            } else {
                position.plus(1)
            }

            LoadResult.Page(
                data = response.results.orEmpty(),
                prevKey = null,
                nextKey = nextKey
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieResults>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}