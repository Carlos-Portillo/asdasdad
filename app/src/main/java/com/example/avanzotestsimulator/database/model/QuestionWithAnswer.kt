package com.example.avanzotestsimulator.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class QuestionWithAnswer(
    @Embedded val question: QuestionModel,
    @Relation(
        parentColumn = "questionId",
        entityColumn = "questionId",
    )
    val answers: List<AnswerModel>
)
