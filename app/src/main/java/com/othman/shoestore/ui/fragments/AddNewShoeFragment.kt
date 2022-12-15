package com.othman.shoestore.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.othman.shoestore.R
import com.othman.shoestore.databinding.FragmentAddNewShoeBinding
import com.othman.shoestore.pojo.ShoeItem
import com.othman.shoestore.viewModels.SharedViewModel

class AddNewShoeFragment : Fragment() {

    private lateinit var binding: FragmentAddNewShoeBinding

    private val viewModel: SharedViewModel by activityViewModels()

    private var newShoeItem = ShoeItem()

    private var editMode = false

    private val args: AddNewShoeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_new_shoe, container, false)

        editMode = args.index != -1
        if (editMode) {
            newShoeItem = viewModel.shoes[args.index]
            activity?.title = "Edit Shoe"
        } else {
            activity?.title = "Add new Shoe"
        }
        binding.newShoe = newShoeItem


        binding.cancelButton.setOnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        }

        binding.saveButton.setOnClickListener {
            if (!editMode) {
                newShoeItem.id = viewModel.shoes.size
                viewModel.shoes.add(newShoeItem)
                Toast.makeText(context, "Shoe added successfully", Toast.LENGTH_LONG).show()
            } else {
                viewModel.shoes[args.index] = newShoeItem
                Toast.makeText(context, "Shoe edited successfully", Toast.LENGTH_LONG).show()
            }

            Navigation.findNavController(binding.root).popBackStack()
        }

        return binding.root
    }

}