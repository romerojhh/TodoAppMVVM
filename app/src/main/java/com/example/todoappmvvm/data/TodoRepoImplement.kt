package com.example.todoappmvvm.data

import kotlinx.coroutines.flow.Flow

/**
 * In this class, we will implement the functions that is defined in
 * TodoRepository.kt
 *
 * If we extend this app with API, this class will be more complex
 */
class TodoRepoImplement(
    // Getting access to our database instance
    // this counts as dependency injection
    private val dao: TodoDao
): TodoRepository {

    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo)
    }

    override suspend fun getTodoById(id: Int): Todo? {
        return dao.getTodoByID(id)
    }

    override fun getTodos(): Flow<List<Todo>> {
        return dao.getTodos()
    }

}