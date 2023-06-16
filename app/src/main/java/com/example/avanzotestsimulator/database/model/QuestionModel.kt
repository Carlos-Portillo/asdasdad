package com.example.avanzotestsimulator.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "question_table")
data class QuestionModel(
    @PrimaryKey(autoGenerate = true) var questionId: Long = 0L,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "image") val image: String,
)
{
    constructor(text: String, description: String, image: String):
            this(0, text, description, image)
}
