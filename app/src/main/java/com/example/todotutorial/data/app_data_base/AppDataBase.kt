package com.example.todotutorial.data.app_data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todotutorial.data.dao.TaskDao
import com.example.todotutorial.data.entity.TaskEntitiy

@Database(entities = [TaskEntitiy::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun taskDao():TaskDao
}