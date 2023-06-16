package com.example.avanzotestsimulator.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.avanzotestsimulator.MainActivity
import com.example.avanzotestsimulator.R
import com.example.avanzotestsimulator.ui.home.ProfileFragment

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton = view.findViewById<Button>(R.id.loginButton)
        val createAccount = view.findViewById<TextView>(R.id.createAccount)
        val forgetPassword = view.findViewById<TextView>(R.id.forgetPassword)

        loginButton.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }

        createAccount.setOnClickListener {
            val fragment = CreateAccountFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(android.R.id.content, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        forgetPassword.setOnClickListener {
            val fragment = ResetPasswordFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(android.R.id.content, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}
