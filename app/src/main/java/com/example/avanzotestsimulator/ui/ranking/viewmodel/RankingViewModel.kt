package com.example.avanzotestsimulator.ui.ranking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.avanzotestsimulator.AvanzoReviewerApplication
import com.example.avanzotestsimulator.database.model.RankingModel
import com.example.avanzotestsimulator.repositories.RankingRepository

class RankingViewModel(private val repository: RankingRepository): ViewModel() {

    // Aqui se implementa LiveData
    var name = MutableLiveData("")
    var points = MutableLiveData("")
    var position = MutableLiveData("")

    suspend fun getRankings() = repository.getRankings()

    // Funcion para implementar el RecyclerView
    fun setSelectedRanking(ranking: RankingModel) {
        name.value = ranking.name
        points.value = ranking.points
        position.value = ranking.position
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AvanzoReviewerApplication
                RankingViewModel(app.rankingRepository)
            }
        }
    }
}