package c.m.popcorn.movie.domain.use_case.get_movie_discover_use_case

import androidx.paging.PagingData
import c.m.popcorn.common.util.Resource
import c.m.popcorn.movie.domain.model.result.MovieResults
import c.m.popcorn.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieDiscoverUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(token: String, page: Int): Flow<Resource<Flow<PagingData<MovieResults>>>> {
        return movieRepository.getMovieDiscover(token, page)
    }
}