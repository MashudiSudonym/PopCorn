package c.m.popcorn.movie.data.remote.dto.detail

import c.m.popcorn.movie.domain.model.detail.MovieGenres
import com.google.gson.annotations.SerializedName

data class MovieGenresDTO(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = ""
) {
    fun toMovieGenres(): MovieGenres {
        return MovieGenres(
            id = id,
            name = name
        )
    }
}
