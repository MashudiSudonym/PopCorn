package c.m.popcorn.movie.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import c.m.popcorn.R
import c.m.popcorn.core.common.Constants
import c.m.popcorn.core.common.Resource
import c.m.popcorn.core.data.remote.PopCornApi
import c.m.popcorn.core.util.UIText
import c.m.popcorn.movie.data.local.MovieDao
import c.m.popcorn.movie.data.paging.MoviePagingSource
import c.m.popcorn.movie.domain.model.detail.MovieDetail
import c.m.popcorn.movie.domain.model.result.MovieResults
import c.m.popcorn.movie.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException

class MovieRepositoryImpl(private val popCornApi: PopCornApi, private val movieDao: MovieDao) :
    MovieRepository {
    override suspend fun getMovieDiscover(
        token: String,
        page: Int
    ): Flow<PagingData<MovieResults>> {
        val totalPages = popCornApi.movieDiscover(token, page).toMovieDiscover()

        return Pager(config = PagingConfig(
            pageSize = totalPages.totalPages ?: page,
            enablePlaceholders = false
        ),
            pagingSourceFactory = {
                MoviePagingSource(
                    popCornApi = popCornApi,
                    querySearch = Constants.IS_BLANK,
                    token = token,
                    page = page
                )
            }
        ).flow.flowOn(Dispatchers.IO)
    }

    override suspend fun getSearchMovies(
        token: String,
        querySearch: String,
        page: Int
    ): Flow<PagingData<MovieResults>> {
        val totalPages = popCornApi.searchMovies(token, querySearch, page).toMovieSearch()

        return Pager(config = PagingConfig(
            pageSize = totalPages.totalPages ?: page,
            enablePlaceholders = false
        ),
            pagingSourceFactory = {
                MoviePagingSource(
                    popCornApi = popCornApi,
                    querySearch = querySearch,
                    token = token,
                    page = page
                )
            }
        ).flow.flowOn(Dispatchers.IO)
    }

    override suspend fun getMovieDetail(token: String, movieId: Int): Flow<Resource<MovieDetail>> {
        return flow {
            emit(Resource.Loading())

            val movieDetail = movieDao.getMovieDetail(movieId).toMovieDetail()
            emit(Resource.Loading(data = movieDetail))

            try {
                val remoteMovieDetail = popCornApi.movieDetail(token, movieId)

                movieDao.updateMovieDetail(movieId, remoteMovieDetail.toMovieDetailEntity())
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        message = UIText.StringResource(R.string.oops),
                        data = movieDetail
                    )
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        message = UIText.StringResource(R.string.internet_problem),
                        data = movieDetail
                    )
                )
            }

            val newMovieDetail = movieDao.getMovieDetail(movieId).toMovieDetail()
            emit(Resource.Success(newMovieDetail))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getLastSeenMovies(): Flow<Resource<List<MovieDetail>>> {
        return flow {
            emit(Resource.Loading())

            val lastSeenMovies = movieDao.getLastSeenMovies().map { it.toMovieDetail() }

            emit(Resource.Success(lastSeenMovies))
        }.flowOn(Dispatchers.IO)
    }
}