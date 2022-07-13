package com.example.todoappmvvm.ui.todo_list

import com.example.todoappmvvm.data.Todo

/**
 * Each screen in MVVM have to have event class
 * that contains all of the UI events that can happen
 * on a single screen
 */
sealed class TodoListEvent {
    /**
     * Delete a todo element
     */
    data class OnDeleteTodoClick(val todo: Todo): TodoListEvent()

    /**
     * Changing the 'done' state of a specific todo element
     */
    data class OnDoneChange(val todo: Todo, val isDone: Boolean): TodoListEvent()

    /**
     * Undo the deletion of todo
     */
    object OnUndoDeleteClick: TodoListEvent()

    /**
     * When we click todo item to get detailed view
     */
    data class OnTodoClick(val todo: Todo): TodoListEvent()

    object OnAddTodoClick: TodoListEvent()
}
