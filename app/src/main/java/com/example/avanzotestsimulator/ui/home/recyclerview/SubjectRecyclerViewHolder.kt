package com.example.avanzotestsimulator.ui.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.avanzotestsimulator.database.model.SubjectModel

import com.example.avanzotestsimulator.databinding.SubjectItemBinding

class SubjectRecyclerViewHolder(private val binding: SubjectItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(subject: SubjectModel, clickListener: (SubjectModel) -> Unit) {
        binding.subjectTitle.text = subject.name

        binding.cardView.setOnClickListener {
            clickListener(subject)
        }
    }
}