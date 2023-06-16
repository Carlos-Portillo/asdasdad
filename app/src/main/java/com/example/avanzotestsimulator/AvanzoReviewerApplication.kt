package com.example.avanzotestsimulator

import android.app.Application
import com.example.avanzotestsimulator.database.AvanzoTestSimulatorDataBase
import com.example.avanzotestsimulator.repositories.SubjectRepository
import com.example.avanzotestsimulator.repositories.RankingRepository

class AvanzoReviewerApplication: Application()  {
    //Instaciamos la base de datos
    private val database: AvanzoTestSimulatorDataBase by lazy {
        AvanzoTestSimulatorDataBase.newInstance(this)
    }

    // Inyectar los dao en los repositorios
    val rankingRepository: RankingRepository by lazy {
        RankingRepository(database.rankingDao())
    }

    val subjectRepository: SubjectRepository by lazy {
        SubjectRepository(database.subjectDao())
    }
}