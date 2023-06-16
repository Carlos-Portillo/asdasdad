package com.example.avanzotestsimulator.ui.ranking.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.avanzotestsimulator.database.model.RankingModel
import com.example.avanzotestsimulator.databinding.RankingItemBinding
import java.text.FieldPosition

class RankingRecyclerViewHolder(private val binding: RankingItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(ranking: RankingModel, clickListener: (RankingModel) -> Unit,position: Int) {
        binding.userName.text = ranking.name
        binding.numberPoints.text = ranking.points
        binding.positionText.text = (position+1).toString()
//        binding.positionText.text = ranking.position


        binding.card.setOnClickListener {
            clickListener(ranking)
        }
    }

}