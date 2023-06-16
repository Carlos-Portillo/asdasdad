package com.example.avanzotestsimulator.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "answer_table")
data class AnswerModel(
    @PrimaryKey(autoGenerate = true) var answerId: Long = 0L,
    @ColumnInfo(name = "questionId") val questionId: Long,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "isCorrect") val isCorrect: Boolean,
){
    constructor(questionId: Long, text: String, isCorrect: Boolean): this(0, questionId, text, isCorrect)
}
