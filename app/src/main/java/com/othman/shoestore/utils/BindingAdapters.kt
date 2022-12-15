package com.othman.shoestore.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUri: String?) {
    if (!imageUri.isNullOrBlank()) {
        Glide.with(view.context).load(imageUri).diskCacheStrategy(DiskCacheStrategy.DATA).into(view)
    }
}