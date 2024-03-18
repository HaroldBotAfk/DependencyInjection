package com.ru.dependency.injection.ui.list

import com.ru.dependency.injection.data.db.UserListRepository
import com.ru.dependency.injection.data.db.dao.UserDao
import com.ru.dependency.injection.data.models.User
import javax.inject.Inject
import kotlin.random.Random

//Говорим прямо "создай репозиторий с помощью этой инъекции в конструктор"
class UserListRepositoryImpl @Inject constructor(
    private val userDao: UserDao
): UserListRepository {
    override fun createUser(): User {
        val countDesc = Random.nextInt(2, 5)  //от 2 до 4
        var desc = ""
        for (i in 0..countDesc) {
            desc += "делает что-то интересное "
        }
        return User(0, "Данила Швед", desc)
    }

    override suspend fun getUsers(): List<User> {
        return userDao.getAllUser()
    }

    override suspend fun insertUser(newUser: User) {
        userDao.insertUser(listOf(newUser))
    }

    override suspend fun deleteUser(userID: Int) {
        userDao.deleteUser(userID)
    }
}