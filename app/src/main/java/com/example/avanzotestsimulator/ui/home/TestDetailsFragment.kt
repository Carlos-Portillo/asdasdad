package com.example.avanzotestsimulator.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import com.example.avanzotestsimulator.MainActivity
import com.example.avanzotestsimulator.R
import com.example.avanzotestsimulator.databinding.FragmentHomeBinding
import com.example.avanzotestsimulator.databinding.FragmentTestDetailsBinding
import com.example.avanzotestsimulator.ui.home.viewmodel.HomeViewModel
import com.example.avanzotestsimulator.ui.tests.TestFragment

class TestDetailsFragment : Fragment() {

    private lateinit var binding: FragmentTestDetailsBinding

    private val homeViewModel: HomeViewModel by activityViewModels {
        HomeViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTestDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()

        val backButton = view.findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        val testButton = view.findViewById<Button>(R.id.TestButton)
        testButton.setOnClickListener {
            val fragment = TestFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(android.R.id.content, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun setViewModel() {
        binding.viewmodel = homeViewModel
    }

}