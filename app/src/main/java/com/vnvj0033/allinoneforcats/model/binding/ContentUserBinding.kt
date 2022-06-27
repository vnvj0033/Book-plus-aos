package com.vnvj0033.allinoneforcats.model.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, src: String) {
    Glide.with(imageView).load(src).into(imageView)
}

@BindingAdapter("intToText")
fun intToText(textView: TextView, num: Int) {
    textView.text = num.toString()
}