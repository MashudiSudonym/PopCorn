package c.m.popcorn.domain.use_case.movie.get_last_seen_movies_use_case

import c.m.popcorn.common.Resource
import c.m.popcorn.domain.model.movie.detail.MovieDetail
import c.m.popcorn.domain.repository.movie.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetLastSeenMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(): Flow<Resource<List<MovieDetail>>> {
        return movieRepository.getLastSeenMovies()
    }
}