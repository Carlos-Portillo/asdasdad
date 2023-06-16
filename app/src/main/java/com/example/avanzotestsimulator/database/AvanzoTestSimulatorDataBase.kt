package com.example.avanzotestsimulator.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.avanzotestsimulator.database.dao.AnswerDao
import com.example.avanzotestsimulator.database.dao.QuestionDao
import com.example.avanzotestsimulator.database.dao.QuizDao
import com.example.avanzotestsimulator.database.dao.RankingDao
import com.example.avanzotestsimulator.database.dao.SubjectDao
import com.example.avanzotestsimulator.database.dao.UserDao
import com.example.avanzotestsimulator.database.model.AnswerModel
import com.example.avanzotestsimulator.database.model.QuestionModel
import com.example.avanzotestsimulator.database.model.QuizModel
import com.example.avanzotestsimulator.database.model.RankingModel
import com.example.avanzotestsimulator.database.model.SubjectModel
import com.example.avanzotestsimulator.database.model.UserModel

@Database(entities = [RankingModel::class, UserModel::class, SubjectModel::class], version = 3)
abstract class AvanzoTestSimulatorDataBase : RoomDatabase() {

    //abstract fun answerDao(): AnswerDao
    //abstract fun questionDao(): QuestionDao
    //abstract fun quizDao(): QuizDao
    abstract fun rankingDao(): RankingDao
    abstract fun subjectDao(): SubjectDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AvanzoTestSimulatorDataBase? = null

        //Si la instancia no existe se construye de manera segura
        fun newInstance(application: Application): AvanzoTestSimulatorDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application.applicationContext,
                    AvanzoTestSimulatorDataBase::class.java,
                    "avanzo_test_simulator"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                instance
            }
        }
    }
}