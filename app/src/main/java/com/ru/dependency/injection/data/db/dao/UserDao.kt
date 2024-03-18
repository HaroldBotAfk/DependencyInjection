package com.ru.dependency.injection.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ru.dependency.injection.data.db.contracts.UsersContact
import com.ru.dependency.injection.data.models.User

@Dao
interface UserDao {

    @Query("SELECT * FROM ${UsersContact.TABLE_NAME}")
    suspend fun getAllUser(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: List<User>)

    @Query("DELETE FROM ${UsersContact.TABLE_NAME} WHERE ${UsersContact.Columns.ID} =:userID")
    suspend fun deleteUser(userID: Int)
}