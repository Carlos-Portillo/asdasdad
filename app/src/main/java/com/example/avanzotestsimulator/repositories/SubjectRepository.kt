package com.example.avanzotestsimulator.repositories

import com.example.avanzotestsimulator.database.dao.SubjectDao

class SubjectRepository(private val rankingDao: SubjectDao) {

        suspend fun getSubjects() = rankingDao.getAllSubjects()

}