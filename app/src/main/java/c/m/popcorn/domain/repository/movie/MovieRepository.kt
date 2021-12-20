package c.m.popcorn.domain.repository.movie

import androidx.paging.PagingData
import c.m.popcorn.common.Resource
import c.m.popcorn.domain.model.movie.detail.MovieDetail
import c.m.popcorn.domain.model.movie.result.MovieResults
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovieDiscover(token: String, page: Int): Flow<PagingData<MovieResults>>
    suspend fun getSearchMovies(token: String, querySearch: String, page: Int): Flow<PagingData<MovieResults>>
    suspend fun getMovieDetail(token: String, movieId: Int): Flow<Resource<MovieDetail>>
    suspend fun getLastSeenMovies(): Flow<Resource<List<MovieDetail>>>
}