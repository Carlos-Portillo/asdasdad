package com.example.avanzotestsimulator.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.avanzotestsimulator.database.model.RankingModel


@Dao
interface RankingDao {

    //Muestra el ranking ordenado por puntos
    @Query("SELECT * FROM ranking_table ORDER BY points DESC")
    suspend fun getAllRanking(): List<RankingModel>

    //Busca un ranking por id
    @Query("SELECT * FROM ranking_table WHERE rankingId = :rankingId")
    suspend fun getRankingById(rankingId: Int): RankingModel?

}