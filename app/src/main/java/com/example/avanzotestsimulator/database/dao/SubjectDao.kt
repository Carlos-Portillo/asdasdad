package com.example.avanzotestsimulator.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.avanzotestsimulator.database.model.SubjectModel


@Dao
interface SubjectDao {

    @Query("SELECT * FROM subject_table")
    suspend fun getAllSubjects(): List<SubjectModel>
}