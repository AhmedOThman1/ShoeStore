package com.othman.shoestore.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.othman.shoestore.pojo.ShoeItem

class ShoesViewModel : ViewModel() {

    private val _shoes = MutableLiveData<ArrayList<ShoeItem>>()
    val shoes: LiveData<ArrayList<ShoeItem>>
        get() = _shoes

    init {
        _shoes.value = ArrayList()
        initShoesList()
    }


    private fun initShoesList() {
        shoes.value?.add(
            ShoeItem(
                0,
                "Nike Zoom",
                "Nike",
                "This shoe is the Nike Air Zoom 33 Shield Id Women's Running - Nike Air Zoom 33 Shield Id Men's Running Shoe",
                43,
                "https://o.remove.bg/downloads/5cd812db-d2bd-47df-b407-a0a30b9764eb/327-3278974_nike-air-zoom-pegasus-33-shield-id-womens-removebg-preview.png"
            )
        )
        shoes.value?.add(
            ShoeItem(
                1,
                "Nike Air Max",
                "Nike",
                "This shoe is the Nike Air Max 2017 Id Women's Running Shoe - Nike Air Max 90 Essential Id Mens Red",
                41,
                "https://i.imgur.com/36ZCrsQ.png"
            )
        )
        shoes.value?.add(
            ShoeItem(
                2,
                "Denim Sneakers",
                "Sneakers",
                "A wonderful shoe from denim sneakers shoes",
                39,
                "https://o.remove.bg/downloads/8a06d3fd-60fd-4b73-87fe-b4afd58a4540/8c3409397b8b6194beb1e9ff2311e34d-removebg-preview.png"
            )
        )
        shoes.value?.add(
            ShoeItem(
                3,
                "All Star",
                "Converse",
                "The Chuck Taylor All Star Hi M9622 is second to none in the world of sneakers. Initially created as a basketball shoe, it very soon became an icon and the most popular sneaker in the world, manufactured in thousands colourways and bilions of pieces.",
                44,
                "https://www.freepnglogos.com/uploads/shoes-png/shoes-shoe-png-transparent-shoe-images-pluspng-37.png"
            )
        )
        shoes.value?.add(
            ShoeItem(
                4,
                "Nike Pegasus 30",
                "Nike",
                "This shoe is the Nike Air Pegasus 30 Shield Id Women's Running - Nike Air Pegasus 30 Shield Id Men's Running Shoe",
                43,
                "https://freepngimg.com/download/shoes/28530-3-nike-shoes-transparent.png"
            )
        )

    }


}