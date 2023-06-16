package com.example.avanzotestsimulator.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_table")
data class QuizModel(
    @PrimaryKey(autoGenerate = true) var quizId: Long = 0L,
    @ColumnInfo(name = "userId") val userId: Long,
    @ColumnInfo(name = "subjectId") val subjectId: Long,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "score") val score: String,
    @ColumnInfo(name = "mode") val mode: String,
){
    constructor(userId: Long, subjectId: Long, status: String, score: String, mode: String):
            this(0, userId, subjectId, status, score, mode)
}

