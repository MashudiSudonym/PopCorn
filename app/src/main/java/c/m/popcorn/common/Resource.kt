package c.m.popcorn.common

import c.m.popcorn.util.UIText

sealed class Resource<T>(val data: T? = null, val uiText: UIText? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: UIText, data: T? = null) : Resource<T>(data, message)
}