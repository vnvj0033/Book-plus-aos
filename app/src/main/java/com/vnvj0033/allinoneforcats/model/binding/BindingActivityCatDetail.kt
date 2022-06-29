package com.vnvj0033.allinoneforcats.model.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.vnvj0033.allinoneforcats.R

object BindingActivityCatDetail {

    @JvmStatic
    @BindingAdapter("loadCatImage")
    fun loadCatImage(imageView: ImageView, src: String) {
        if (src.isEmpty()) {
            imageView.setImageResource(R.drawable.ic_blank_cat)
        } else {
            Glide.with(imageView).load(src).into(imageView)
        }
    }
}