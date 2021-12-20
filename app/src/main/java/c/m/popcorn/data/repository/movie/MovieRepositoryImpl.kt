package c.m.popcorn.data.repository.movie

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import c.m.popcorn.R
import c.m.popcorn.common.Constants
import c.m.popcorn.common.Resource
import c.m.popcorn.data.local.movie.MovieDao
import c.m.popcorn.data.paging.movie.MoviePagingSource
import c.m.popcorn.data.remote.PopCornApi
import c.m.popcorn.domain.model.movie.detail.MovieDetail
import c.m.popcorn.domain.model.movie.result.MovieResults
import c.m.popcorn.domain.repository.movie.MovieRepository
import c.m.popcorn.util.UIText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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
                    querySearch = Constants.IS_BLANK,
                    token = token,
                    page = page
                )
            }
        ).flow.flowOn(Dispatchers.IO)
    }

    override suspend fun getMovieDetail(token: String, movieId: Int): Flow<Resource<MovieDetail>> =
        flow {
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

    override suspend fun getLastSeenMovies(): Flow<Resource<List<MovieDetail>>> = flow {
        emit(Resource.Loading())

        val lastSeenMovies = movieDao.getLastSeenMovies().map { it.toMovieDetail() }

        emit(Resource.Success(lastSeenMovies))
    }.flowOn(Dispatchers.IO)
}