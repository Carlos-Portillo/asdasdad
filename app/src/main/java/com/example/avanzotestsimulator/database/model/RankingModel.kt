package com.example.avanzotestsimulator.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "ranking_table")
data class RankingModel(
    @PrimaryKey(autoGenerate = true) var rankingId: Long = 0L, //
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "points") val points: String,
    @Ignore val position: String = "",
)
{
    constructor(name: String, points: String):
            this(0,name,points)
}
