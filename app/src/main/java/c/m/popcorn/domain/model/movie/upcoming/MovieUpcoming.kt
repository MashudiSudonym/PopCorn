package c.m.popcorn.domain.model.movie.upcoming

data class MovieUpcoming(
    val page: Int? = 0,
    val results: List<MovieUpcomingResults>? = emptyList(),
    val dates: MovieDates = MovieDates(),
    val totalPages: Int? = 0,
    val totalResult: Int? = 0,
)
