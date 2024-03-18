package com.ru.dependency.injection.data.db

import com.ru.dependency.injection.data.models.User

interface UserListRepository {

    fun createUser(): User
    suspend fun getUsers(): List<User>
    suspend fun insertUser(newUser: User)
    suspend fun deleteUser(userID: Int)
}