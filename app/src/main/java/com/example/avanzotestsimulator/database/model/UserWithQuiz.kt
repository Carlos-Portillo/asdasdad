package com.example.avanzotestsimulator.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithQuiz(
    @Embedded val user: UserModel,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId",
    )
    val quiz: List<QuizModel>
)
