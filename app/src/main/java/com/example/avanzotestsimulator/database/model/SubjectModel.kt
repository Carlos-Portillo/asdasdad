package com.example.avanzotestsimulator.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subject_table")
data class SubjectModel(
    @PrimaryKey(autoGenerate = true) var subjectId: Long = 0L,
    @ColumnInfo( name = "code") val code: String,
    @ColumnInfo( name = "name") val name: String,
    @ColumnInfo( name = "image") val image: String,
)
{
    constructor(code: String, name: String, image: String): this(0, code, name, image)
}
