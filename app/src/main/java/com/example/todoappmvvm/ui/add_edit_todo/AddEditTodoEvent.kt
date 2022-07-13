package com.example.todoappmvvm.ui.add_edit_todo

sealed class AddEditTodoEvent {

    /**
     * Change text content of title text
     */
    data class OnTitleChange(val title: String): AddEditTodoEvent()

    /**
     * Change text content of description text
     */
    data class OnDescriptionChange(val description: String): AddEditTodoEvent()

    /**
     * User click save
     */
    object OnSaveTodoClick: AddEditTodoEvent()
}
