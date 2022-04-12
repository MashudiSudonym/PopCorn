package c.m.popcorn.movie.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import c.m.popcorn.R
import c.m.popcorn.common.util.Resource
import c.m.popcorn.movie.data.remote.MoviePopCornApi
import c.m.popcorn.common.util.UIText
import c.m.popcorn.movie.data.local.MovieDao
import c.m.popcorn.movie.data.paging.MoviePagingSource
import c.m.popcorn.movie.domain.model.detail.MovieDetail
import c.m.popcorn.movie.domain.model.result.MovieResults
import c.m.popcorn.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

class MovieRepositoryImpl(private val moviePopCornApi: MoviePopCornApi, private val movieDao: MovieDao) :
    MovieRepository {
    override suspend fun getMovieDiscover(
        token: String,
        page: Int
    ): Flow<Resource<Flow<PagingData<MovieResults>>>> =
        flow<Resource<Flow<PagingData<MovieResults>>>> {
            emit(Resource.Loading())

            try {
                val pagingData = Pager(config = PagingConfig(pageSize = 2),
                    pagingSourceFactory = {
                        MoviePagingSource(
                            moviePopCornApi = moviePopCornApi,
                            token = token
                        )
                    }
                ).flow

                emit(Resource.Success(pagingData))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        message = UIText.StringResource(R.string.oops)
                    )
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        message = UIText.StringResource(R.string.internet_problem)
                    )
                )
            } catch (e: UnknownHostException) {
                emit(
                    Resource.Error(
                        message = UIText.StringResource(R.string.internet_problem)
                    )
                )
            }
        }

    override suspend fun getMovieDetail(token: String, movieId: Int): Flow<Resource<MovieDetail>> =
        flow {
            emit(Resource.Loading())

            val movieDetail = movieDao.getMovieDetail(movieId).toMovieDetail()
            emit(Resource.Loading(data = movieDetail))

            try {
                val remoteMovieDetail = moviePopCornApi.movieDetail(token, movieId)

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
        }

    override suspend fun getLastSeenMovies(): Flow<Resource<List<MovieDetail>>> = flow {
        emit(Resource.Loading())

        val lastSeenMovies = movieDao.getLastSeenMovies().map { it.toMovieDetail() }

        emit(Resource.Success(lastSeenMovies))
    }
}