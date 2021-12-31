package c.m.popcorn.domain.use_case.movie.get_movie_discover_use_case

import androidx.paging.PagingData
import c.m.popcorn.domain.model.movie.result.MovieResults
import c.m.popcorn.domain.repository.movie.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieDiscoverUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(token: String, page: Int): Flow<PagingData<MovieResults>> {
        return movieRepository.getMovieDiscover(token, page)
    }
}