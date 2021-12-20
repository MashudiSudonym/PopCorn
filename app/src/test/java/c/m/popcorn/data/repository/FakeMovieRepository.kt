package c.m.popcorn.data.repository

import androidx.paging.PagingData
import c.m.popcorn.common.Resource
import c.m.popcorn.domain.model.movie.detail.MovieDetail
import c.m.popcorn.domain.model.movie.result.MovieResults
import c.m.popcorn.domain.repository.movie.MovieRepository
import c.m.popcorn.dummy.FakeDummyMovieData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeMovieRepository : MovieRepository {
    private val fakeMovieDetail = FakeDummyMovieData().fakeMovieDetail()

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

            emit(Resource.Success(fakeMovieDetail.toMovieDetail()))
        }
    }

    override suspend fun getLastSeenMovies(): Flow<Resource<List<MovieDetail>>> {
        TODO("Not yet implemented")
    }
}