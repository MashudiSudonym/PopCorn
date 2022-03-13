package c.m.popcorn.movie.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import c.m.popcorn.core.data.remote.PopCornApi
import c.m.popcorn.movie.domain.model.result.MovieResults

class MoviePagingSource(
    private val popCornApi: PopCornApi,
    private val querySearch: String,
    private val token: String,
    private val page: Int
) :
    PagingSource<Int, MovieResults>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResults> {
        return try {
            val position = params.key ?: page

            if (querySearch.isBlank()) {
                // Paging for movie discover data
                val response = popCornApi.movieDiscover(token, position).toMovieDiscover()
                val nextKey = if (response.results.orEmpty().isEmpty()) {
                    null
                } else {
                    position.plus(
                        (params.loadSize.div(
                            response.totalPages ?: page
                        ))
                    )
                }

                LoadResult.Page(
                    data = response.results.orEmpty(),
                    prevKey = if (position == page) null else position.minus(
                        page
                    ),
                    nextKey = nextKey
                )
            } else {
                // Paging for searching movie data
                val response = popCornApi.searchMovies(token, querySearch, position).toMovieSearch()
                val nextKey = if (response.results.orEmpty().isEmpty()) {
                    null
                } else {
                    position.plus(
                        (params.loadSize.div(
                            response.totalPages ?: page
                        ))
                    )
                }

                LoadResult.Page(
                    data = response.results.orEmpty(),
                    prevKey = if (position == page) null else position.minus(
                        page
                    ),
                    nextKey = nextKey
                )
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieResults>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(page)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(page)
        }
    }
}