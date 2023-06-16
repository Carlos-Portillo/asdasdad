package com.example.avanzotestsimulator.repositories

import com.example.avanzotestsimulator.database.dao.UserDao
import com.example.avanzotestsimulator.database.model.UserModel

class UserRepository(private val userDao: UserDao) {

        suspend fun getUsers() = userDao.getAllUsers()

        suspend fun getUserById(id: Int) = userDao.getUserById(id)

        suspend fun getUserByName(firstName: String) = userDao.getUserByName(firstName)

        suspend fun insertUser(user: UserModel) = userDao.insertUser(user)

        suspend fun updateUser(user: UserModel) = userDao.updateUser(user)

        suspend fun deleteUser(user: UserModel) = userDao.deleteUser(user)

}