package c.m.popcorn.movie.domain.repository

import androidx.paging.PagingData
import c.m.popcorn.common.util.Resource
import c.m.popcorn.movie.domain.model.detail.MovieDetail
import c.m.popcorn.movie.domain.model.result.MovieResults
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovieDiscover(token: String, page: Int): Flow<Resource<Flow<PagingData<MovieResults>>>>
    suspend fun getMovieDetail(token: String, movieId: Int): Flow<Resource<MovieDetail>>
    suspend fun getLastSeenMovies(): Flow<Resource<List<MovieDetail>>>
}