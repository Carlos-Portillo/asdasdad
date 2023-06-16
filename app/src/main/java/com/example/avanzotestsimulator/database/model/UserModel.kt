package com.example.avanzotestsimulator.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class UserModel(
    @PrimaryKey(autoGenerate = true) var userId: Long = 0L,
    @ColumnInfo( name = "firstName") val firstName: String,
    @ColumnInfo( name = "lastName") val lastName: String,
    @ColumnInfo( name = "email") val email: String,
    @ColumnInfo( name = "institution") val institution: String,
    @ColumnInfo( name = "birthDate") val birthDate: String,
    //TODO: Add more fields (TOKEN, etc)
)
{
    constructor(firstName: String, lastName: String, email: String, institution: String, birthDate: String):
            this(0, firstName, lastName, email, institution, birthDate)
}