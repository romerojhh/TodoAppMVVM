package com.example.todoappmvvm.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoappmvvm.data.TodoDatabase
import com.example.todoappmvvm.data.TodoRepoImplement
import com.example.todoappmvvm.data.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * App module for hilt injection
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // annotation to indicate that this function provides the singleton dependency
    // i.e., only single instance of dependency exist
    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDatabase): TodoRepository {
        return TodoRepoImplement(db.dao)
    }
}