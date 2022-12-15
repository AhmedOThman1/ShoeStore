package com.othman.shoestore.pojo

data class ShoeItem(
    var id: Int = -1,
    var title: String = "",
    var companyName: String = "",
    var description: String = "",
    var size: Int? = null,
    var imageUrl: String = ""
)