package com.example.todoappmvvm.util

sealed class UiEvent {
    /**
     * Function to pop stack when user press undo / navigate back
     */
    object PopBackStack: UiEvent()

    /**
     * Navigation to a new screen
     * @param route destination to navigate
     */
    data class Navigate(val route: String): UiEvent()

    /**
     * Show snackbar on screen
     * @param message message to user
     * @param action for undo action text
     */
    data class ShowSnackbar(
        val message: String,
        val action: String? = null
    ): UiEvent()
}
