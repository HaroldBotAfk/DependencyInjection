package com.ru.dependency.injection.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ru.dependency.injection.data.db.dao.UserDao
import com.ru.dependency.injection.data.models.User

@Database(
    entities = [
        User::class
    ], version = AppDatabase.DB_VERSION, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "database_name"
    }
}