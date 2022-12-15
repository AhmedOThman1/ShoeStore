package com.othman.shoestore.viewModels

import androidx.lifecycle.ViewModel
import com.othman.shoestore.pojo.ShoeItem

class SharedViewModel : ViewModel() {
    var shoes = ArrayList<ShoeItem>()
}