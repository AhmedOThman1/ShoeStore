package com.othman.shoestore.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.othman.shoestore.R
import com.othman.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding

    private val img = arrayOf(
        R.drawable.instruction1,
        R.drawable.instruction2,
        R.drawable.instruction3,
    )

    private val title = arrayOf(
        R.string.start_the_journey_with_us,
        R.string.awesome_branded_shoes,
        R.string.just_do_it_with_shoe_store
    )

    private val des = arrayOf(
        R.string.get_access_to_more_than_1000_shoes,
        R.string.smart_gorgeous_fashionable_collection,
        R.string.browse_shoes_from_nike_and_also_from_another_brands_with_20_off
    )

    private var index = 0

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)

        binding.next.setOnClickListener {
            if (index < img.size - 1) {
                index++
                binding.image.setImageResource(img[index])
                binding.title.text = getString(title[index])
                binding.description.text = getString(des[index])
                if (index == img.size - 1)
                    binding.next.text = "Get Started!"
            } else {
                Navigation.findNavController(binding.root)
                    .navigate(InstructionFragmentDirections.actionInstructionFragmentToShowShoesListFragment())
            }

        }

        // Inflate the layout for this fragment
        return binding.root
    }


}