package com.example.avanzotestsimulator.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.avanzotestsimulator.database.model.UserModel

@Dao
interface UserDao {

    //Funcion para obtener todos los usuarios
    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers(): List<UserModel>

    //Funcion para insertar un usuario
    @Transaction
    @Insert
    suspend fun insertUser(user: UserModel)

    //Funcion para obtener un usuario por id
    @Query("SELECT * FROM user_table WHERE userId = :userId")
    suspend fun getUserById(userId: Int): UserModel?

    //Funcion para obtener un usuario por nombre
    @Query("SELECT * FROM user_table WHERE firstName = :firstName")
    suspend fun getUserByName(firstName: String): UserModel?

    //Funcion para actualizar un usuario
    @Update
    suspend fun updateUser(user: UserModel)


    //Funcion para eliminar un usuario
    @Transaction
    @Delete
    suspend fun deleteUser(user: UserModel)
}