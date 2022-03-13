package c.m.popcorn.movie.domain.use_case.get_last_seen_movies_use_case

import c.m.popcorn.core.data.repository.FakeMovieRepository
import c.m.popcorn.movie.domain.model.detail.MovieDetail
import c.m.popcorn.dummy.FakeDummyMovieData
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetLastSeenMoviesUseCaseTest {

    private lateinit var getLastSeenMoviesUseCase: GetLastSeenMoviesUseCase
    private lateinit var fakeMovieRepository: FakeMovieRepository
    private lateinit var fakeLastSeenMovies: List<MovieDetail>

    @Before
    fun setUp() {
        fakeLastSeenMovies = FakeDummyMovieData().fakeLastSeenMovies()
        fakeMovieRepository = FakeMovieRepository()
        getLastSeenMoviesUseCase = GetLastSeenMoviesUseCase(fakeMovieRepository)
    }

    @Test
    @Throws(Exception::class)
    fun `check data return according to fake data`() = runBlocking {
        val data = getLastSeenMoviesUseCase().last().data
        val fakeData = fakeLastSeenMovies

        Truth.assertThat(data).isEqualTo(fakeData)
    }
}