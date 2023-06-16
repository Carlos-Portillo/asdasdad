package com.example.avanzotestsimulator.repositories

import com.example.avanzotestsimulator.database.dao.RankingDao
import com.example.avanzotestsimulator.database.model.RankingModel

class RankingRepository(private val rankingDao: RankingDao ) {

    suspend fun getRankings() = rankingDao.getAllRanking()
    suspend fun getRankingById(id: Int) = rankingDao.getRankingById(id)
}