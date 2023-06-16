package com.example.avanzotestsimulator.ui.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avanzotestsimulator.database.model.RankingModel
import com.example.avanzotestsimulator.MainActivity
import com.example.avanzotestsimulator.R
import com.example.avanzotestsimulator.databinding.FragmentRankingBinding
import com.example.avanzotestsimulator.ui.ranking.recyclerview.RankingRecyclerViewAdapter
import com.example.avanzotestsimulator.ui.ranking.viewmodel.RankingViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RankingFragment : Fragment() {

    private val rankingViewModel: RankingViewModel by activityViewModels {
        RankingViewModel.Factory
    }

    private lateinit var binding: FragmentRankingBinding
    private lateinit var adapter: RankingRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRankingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            setRecyclerView(view)
        }

        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    // Funciones para implementar el RecyclerView

    private fun showSelectedItem(ranking: RankingModel) {
        rankingViewModel.setSelectedRanking(ranking)
    }

    private suspend fun displayRankings() {
        adapter.setData(rankingViewModel.getRankings())
        adapter.notifyDataSetChanged()
    }

    private suspend fun setRecyclerView(view: View) {
        binding.RecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = RankingRecyclerViewAdapter { selectedRanking ->
            showSelectedItem(selectedRanking)
        }

        binding.RecyclerView.adapter = adapter
        displayRankings()
    }
}