package com.example.todoappmvvm.data

import kotlinx.coroutines.flow.Flow

/**
 * Making the repository abstract i.e., as interface makes testing easier
 * so that we don't have to test with our actual database
 *
 * contains the same function as TodoDao.kt but without annotation
 */
interface TodoRepository {

    suspend fun insertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)

    suspend fun getTodoById(id: Int): Todo?

    fun getTodos(): Flow<List<Todo>>
}