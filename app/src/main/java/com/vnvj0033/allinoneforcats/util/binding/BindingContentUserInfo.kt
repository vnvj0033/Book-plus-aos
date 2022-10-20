package com.vnvj0033.allinoneforcats.util.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.vnvj0033.allinoneforcats.R

object BindingContentUserInfo {

    @JvmStatic
    @BindingAdapter("loadProfileImage")
    fun loadProfileImage(imageView: ImageView, src: String) {
        if (src.isEmpty()) {
            imageView.setImageResource(R.drawable.ic_blank_profile)
        } else {
            Glide.with(imageView).load(src).into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("intToText")
    fun intToText(textView: TextView, num: Int) {
        textView.text = num.toString()
    }
}
