package c.m.popcorn.movie.domain.use_case.get_last_seen_movies_use_case

import c.m.popcorn.common.util.Resource
import c.m.popcorn.movie.domain.model.detail.MovieDetail
import c.m.popcorn.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetLastSeenMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(): Flow<Resource<List<MovieDetail>>> {
        return movieRepository.getLastSeenMovies()
    }
}