package com.othman.shoestore.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.othman.shoestore.R
import com.othman.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.login.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        binding.signUp.setOnClickListener { binding.login.performClick() }

        return binding.root
    }

}