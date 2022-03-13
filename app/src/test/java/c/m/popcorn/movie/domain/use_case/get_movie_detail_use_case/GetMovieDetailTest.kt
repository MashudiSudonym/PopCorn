package c.m.popcorn.movie.domain.use_case.get_movie_detail_use_case

import c.m.popcorn.R
import c.m.popcorn.core.common.Constants
import c.m.popcorn.movie.data.local.entity.MovieDetailEntity
import c.m.popcorn.core.data.repository.FakeMovieRepository
import c.m.popcorn.dummy.FakeDummyMovieData
import c.m.popcorn.core.util.UIText
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetMovieDetailTest {

    private lateinit var getMovieDetailUseCase: GetMovieDetailUseCase
    private lateinit var fakeMovieRepository: FakeMovieRepository
    private lateinit var fakeMovieDetail: MovieDetailEntity

    @Before
    fun setUp() {
        fakeMovieDetail = FakeDummyMovieData().fakeMovieDetail()
        fakeMovieRepository = FakeMovieRepository()
        getMovieDetailUseCase = GetMovieDetailUseCase(fakeMovieRepository)
    }

    @Test
    @Throws(Exception::class)
    fun `check data return according to fake data`() = runBlocking {
        val data = getMovieDetailUseCase(Constants.TOKEN, 1).last().data
        val fakeData = fakeMovieDetail.toMovieDetail()

        assertThat(data).isEqualTo(fakeData)
    }

    @Test
    @Throws(Exception::class)
    fun `check token is blank`() = runBlocking {
        val token = ""
        val movieId = 1
        val data = getMovieDetailUseCase(token, movieId).last().uiText

        assertThat(data).isEqualTo(UIText.StringResource(R.string.token_is_blank))
    }

    @Test
    @Throws(Exception::class)
    fun `check movie id is 0`() = runBlocking {
        val token = Constants.TOKEN
        val movieId = 0
        val data = getMovieDetailUseCase(token, movieId).last().uiText

        assertThat(data).isEqualTo(UIText.StringResource(R.string.movie_id_is_blank))
    }
}