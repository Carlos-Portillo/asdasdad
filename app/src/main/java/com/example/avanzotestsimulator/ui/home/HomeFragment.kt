package com.example.avanzotestsimulator.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avanzotestsimulator.R
import com.example.avanzotestsimulator.database.model.SubjectModel
import com.example.avanzotestsimulator.databinding.FragmentHomeBinding
import com.example.avanzotestsimulator.ui.home.recyclerview.SubjectRecyclerViewAdapter
import com.example.avanzotestsimulator.ui.home.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by activityViewModels {
        HomeViewModel.Factory
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: SubjectRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            setRecyclerView(view)
        }

        val userButton = view.findViewById<ImageButton>(R.id.userButton)
        userButton.setOnClickListener {
            val fragment = ProfileFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(android.R.id.content, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }

    // Funciones para implementar el RecyclerView
    private fun showSelectedItem(subject: SubjectModel) {
        homeViewModel.setSelectedSubject(subject)
        val fragment = TestDetailsFragment()
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(android.R.id.content, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private suspend fun displaySubjects() {
        adapter.setData(homeViewModel.getSubjects())
        adapter.notifyDataSetChanged()
    }

    private suspend fun setRecyclerView(view: View) {
        binding.RecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = SubjectRecyclerViewAdapter { selectedSubject ->
            showSelectedItem(selectedSubject)
        }

        binding.RecyclerView.adapter = adapter
        displaySubjects()
    }
}