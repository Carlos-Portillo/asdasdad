package com.example.avanzotestsimulator.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class QuizWithSubject(
    @Embedded val quiz: QuizModel,
    @Relation(
        parentColumn = "subjectId",
        entityColumn = "subjectId",
    )
    val subject: SubjectModel
)
