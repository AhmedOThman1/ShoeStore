package com.othman.shoestore.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.othman.shoestore.R
import com.othman.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)


        binding.next.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}