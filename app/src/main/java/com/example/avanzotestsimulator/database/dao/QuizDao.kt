package com.example.avanzotestsimulator.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.avanzotestsimulator.database.model.QuizModel
@Dao
interface QuizDao {

    @Query("SELECT * FROM quiz_table")
    suspend fun getAllQuizzes(): List<QuizModel>
}