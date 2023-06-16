package com.example.avanzotestsimulator.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.avanzotestsimulator.database.model.QuestionModel


@Dao
interface QuestionDao {

    //Muestra todas las preguntas
    @Query("SELECT * FROM question_table")
    suspend fun getAllQuestions(): List<QuestionModel>

    //Muestra una pregunta por id
    @Transaction
    @Query("SELECT * FROM question_table WHERE questionId = :questionId")
    suspend fun getQuestionById(questionId: Int): QuestionModel?

    //Inserta una pregunta
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuestionModel)

}