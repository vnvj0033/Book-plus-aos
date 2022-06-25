package com.vnvj0033.allinoneforcats.model.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, src: String) =
    Glide.with(imageView).load(src).into(imageView)

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, id: Int) =
    Glide.with(imageView).load(id).into(imageView)
