package com.example.todoappmvvm.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Dao stands for data access object
 * It is used to access data
 */
@Dao
interface TodoDao {

    // Suspend means waiting the current execution until the function is finished
    /**
     * Insert a todo item
     */
    // The conflict strategy states that when we have a todo item that is already on the database
    // we will replace the old todo item with the new one
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    /**
     * Delete a todo item
     */
    @Delete
    suspend fun deleteTodo(todo: Todo)

    /**
     * Retrieve a todo item by its ID
     */
    // Select all the properties from todo table where the id is the function argument id
    @Query("SELECT * FROM todo WHERE id = :id")
    suspend fun getTodoByID(id: Int): Todo?

    /**
     * Retrieve all todo items
     */
    // Flow gives us the ability to see in real-time change
    // as soon as the data in the database changes.
    // Flow will get triggered everytime data is changed

    // Select everything from todo table
    @Query("SELECT * FROM todo")
    fun getTodos(): Flow<List<Todo>>
}