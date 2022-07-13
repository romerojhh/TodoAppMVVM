package com.example.todoappmvvm.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * This class is an abstract class
 *
 * TODO: Ask max what is the purpose of this class
 */
@Database (
    entities = [Todo::class],
    // everytime you change database, increment the version
    version = 1
)
abstract class TodoDatabase: RoomDatabase() {

    abstract val dao: TodoDao
}