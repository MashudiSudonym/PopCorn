package c.m.popcorn.movie.domain.use_case.get_search_movies_use_case

import androidx.paging.PagingData
import c.m.popcorn.movie.domain.model.result.MovieResults
import c.m.popcorn.movie.domain.repository.MovieRepository
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