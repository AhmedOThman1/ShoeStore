package com.othman.shoestore.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.othman.shoestore.R
import com.othman.shoestore.databinding.FragmentShowShoesListBinding
import com.othman.shoestore.databinding.OneShoeItemBinding
import com.othman.shoestore.viewModels.SharedViewModel
import com.othman.shoestore.viewModels.ShoesViewModel
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt

class ShowShoesListFragment : Fragment() {

    private lateinit var bindingView: FragmentShowShoesListBinding
    private lateinit var shoesViewModel: ShoesViewModel

    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingView =
            DataBindingUtil.inflate(inflater, R.layout.fragment_show_shoes_list, container, false)

        shoesViewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)

        initItemsInsideLayout()

        bindingView.addNewShoe.setOnClickListener {
            Navigation.findNavController(bindingView.root)
                .navigate(ShowShoesListFragmentDirections.actionShowShoesListFragmentToAddNewShoeFragment())
        }

        setHasOptionsMenu(true)

        return bindingView.root
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        // Handle the menu selection
        return when (menuItem.itemId) {
            R.id.logout -> {
                Toast.makeText(
                    activity,
                    "Logout successfully",
                    Toast.LENGTH_LONG
                ).show()
                Navigation.findNavController(bindingView.root)
                    .navigate(ShowShoesListFragmentDirections.actionShowShoesListFragmentToLoginFragment())
                true
            }
            else -> false
        }
    }


    private fun initItemsInsideLayout() {
        for (view in bindingView.shoesLayout.children)
            if (view.id != R.id.add_new_shoe)
                bindingView.shoesLayout.removeView(view)

        if (sharedViewModel.shoes.isEmpty())
            sharedViewModel.shoes = shoesViewModel.shoes.value!!

        for (shoe in sharedViewModel.shoes) {
            val binding: OneShoeItemBinding = OneShoeItemBinding.inflate(layoutInflater)
            binding.shoeItem = shoe
            binding.shoeImg.setOnClickListener {
                MaterialTapTargetPrompt.Builder(this)
                    .setTarget(binding.shoeImg)
                    .setPrimaryText(shoe.title)
                    .setSecondaryText("Company: " + shoe.companyName + "\n\n" + shoe.description)
                    .show()
            }
            binding.shoeTitle.setOnClickListener { binding.shoeImg.performClick() }

            binding.shoeImg.setOnLongClickListener {
                val popupMenu = PopupMenu(requireContext(), binding.shoeImg)
                popupMenu.menu.add("Edit")
                popupMenu.setOnMenuItemClickListener {
                    if (it.title == "Edit") {
                        Navigation.findNavController(binding.root)
                            .navigate(
                                ShowShoesListFragmentDirections.actionShowShoesListFragmentToAddNewShoeFragment(
                                    shoe.id
                                )
                            )
                    }
                    false
                }
                popupMenu.show()
                true
            }
            bindingView.shoesLayout.addView(binding.root, bindingView.shoesLayout.childCount - 1)
        }

    }


}