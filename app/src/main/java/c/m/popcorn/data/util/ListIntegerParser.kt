package c.m.popcorn.data.util

import java.lang.reflect.Type

interface ListIntegerParser {

    fun <T> fromListInt(json: Int, type: Type): T?

    fun <T> toListInt(obj: T, type: Type): Int?
}