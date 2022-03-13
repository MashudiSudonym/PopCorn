package c.m.popcorn.core.data.repository

import androidx.paging.PagingData
import c.m.popcorn.core.common.Resource
import c.m.popcorn.movie.domain.model.detail.MovieDetail
import c.m.popcorn.movie.domain.model.result.MovieResults
import c.m.popcorn.movie.domain.repository.MovieRepository
import c.m.popcorn.dummy.FakeDummyMovieData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeMovieRepository : MovieRepository {
    private val fakeLastSeenMovieData = FakeDummyMovieData().fakeLastSeenMovies()
    private val fakeMovieDetailData = FakeDummyMovieData().fakeMovieDetail()

    override suspend fun getMovieDiscover(
        token: String,
        page: Int
    ): Flow<PagingData<MovieResults>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSearchMovies(
        token: String,
        querySearch: String,
        page: Int
    ): Flow<PagingData<MovieResults>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieDetail(token: String, movieId: Int): Flow<Resource<MovieDetail>> {
        return flow {
            emit(Resource.Loading())

            emit(Resource.Success(fakeMovieDetailData.toMovieDetail()))
        }
    }

    override suspend fun getLastSeenMovies(): Flow<Resource<List<MovieDetail>>> {
        return flow {
            emit(Resource.Loading())

            emit(Resource.Success(fakeLastSeenMovieData))
        }
    }
}