package c.m.popcorn.movie.domain.use_case.get_movie_detail_use_case

import c.m.popcorn.R
import c.m.popcorn.core.common.Resource
import c.m.popcorn.movie.domain.model.detail.MovieDetail
import c.m.popcorn.movie.domain.repository.MovieRepository
import c.m.popcorn.core.util.UIText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMovieDetailUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(token: String, movieId: Int): Flow<Resource<MovieDetail>> {
        if (token.isBlank()) {
            return flow { emit(Resource.Error(UIText.StringResource(R.string.token_is_blank))) }
        }

        if (movieId == 0) {
            return flow { emit(Resource.Error(UIText.StringResource(R.string.movie_id_is_blank))) }
        }

        return movieRepository.getMovieDetail(token, movieId)
    }
}