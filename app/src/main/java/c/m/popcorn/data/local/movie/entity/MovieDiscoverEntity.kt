package c.m.popcorn.data.local.movie.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import c.m.popcorn.domain.model.movie.discover.MovieDiscover
import c.m.popcorn.domain.model.movie.discover.MovieResults

@Entity(tableName = "movie_discover")
data class MovieDiscoverEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Long = 0L,
    @ColumnInfo(name = "page")
    val page: Int?,
    @ColumnInfo(name = "results")
    val results: List<MovieResults>?,
    @ColumnInfo(name = "total_resuts")
    val totalResults: Int?,
    @ColumnInfo(name = "total_pages")
    val totalPages: Int?
) {
    fun toMovieDiscover(): MovieDiscover {
        return MovieDiscover(
            page = page,
            results = results,
            totalResult = totalResults,
            totalPages = totalPages
        )
    }
}
