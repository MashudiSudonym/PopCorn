package c.m.popcorn.domain.use_case.movie.get_search_movies_use_case

import androidx.paging.PagingData
import c.m.popcorn.domain.model.movie.result.MovieResults
import c.m.popcorn.domain.repository.movie.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetSearchMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(
        querySearch: String,
        token: String,
        page: Int
    ): Flow<PagingData<MovieResults>> {
        return movieRepository.getSearchMovies(token, querySearch, page)
    }
}