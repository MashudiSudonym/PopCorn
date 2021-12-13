package c.m.popcorn.data.local

import androidx.room.TypeConverter
import c.m.popcorn.data.util.JsonParser
import c.m.popcorn.domain.model.movie.detail.MovieGenres
import com.google.gson.reflect.TypeToken

class Converters(private val jsonParser: JsonParser) {
    @TypeConverter
    fun fromGenresJson(json: String): List<MovieGenres> {
        return jsonParser.fromJson(json, object : TypeToken<List<MovieGenres>>() {}.type)
            ?: emptyList()
    }

    @TypeConverter
    fun toGenresJson(genres: List<MovieGenres>): String {
        return jsonParser.toJson(genres, object : TypeToken<List<MovieGenres>>() {}.type) ?: ""
    }
}