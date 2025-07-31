package com.example.todotutorial.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todotutorial.data.entity.TaskEntitiy
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task:TaskEntitiy)

    @Update
    suspend fun UpdateTask(task: TaskEntitiy)

    @Delete
    suspend fun DeleteTask(task: TaskEntitiy)

    @Query("SELECT * FROM TodoList ORDER BY id DESC")
    fun getAllTasks() : Flow<List<TaskEntitiy>>
}