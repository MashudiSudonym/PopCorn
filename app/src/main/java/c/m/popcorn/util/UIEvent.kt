package c.m.popcorn.util

sealed class UIEvent {
    data class ShowSnackbar(val message: String) : UIEvent()
}