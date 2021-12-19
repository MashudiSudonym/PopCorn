package c.m.popcorn.domain.repository.movie

import c.m.popcorn.common.Resource
import c.m.popcorn.domain.model.movie.detail.MovieDetail
import c.m.popcorn.domain.model.movie.discover.MovieDiscover
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovieDiscover(token: String, page: Int): Flow<Resource<MovieDiscover>>
    suspend fun getSearchMovies(token: String, querySearch: String, page: Int): Flow<Resource<MovieDiscover>>
    suspend fun getMovieDetail(token: String, movieId: Int): Flow<Resource<MovieDetail>>
    suspend fun getLastSeenMovies(): Flow<Resource<List<MovieDetail>>>
}