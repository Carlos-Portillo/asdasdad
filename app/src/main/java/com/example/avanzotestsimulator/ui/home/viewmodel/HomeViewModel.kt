package com.example.avanzotestsimulator.ui.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.avanzotestsimulator.AvanzoReviewerApplication
import com.example.avanzotestsimulator.database.model.SubjectModel
import com.example.avanzotestsimulator.repositories.SubjectRepository

class HomeViewModel(private val repository: SubjectRepository): ViewModel()  {
    // Aqui se implementa LiveData
    var name = MutableLiveData("")
    var image = MutableLiveData("")

    suspend fun getSubjects() = repository.getSubjects()

    // Funcion para implementar el RecyclerView
    fun setSelectedSubject(subject: SubjectModel) {
        name.value = subject.name
        image.value = subject.image
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AvanzoReviewerApplication
                HomeViewModel(app.subjectRepository)
            }
        }
    }
}