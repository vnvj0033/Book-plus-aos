package com.vnvj0033.allinoneforcats.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vnvj0033.allinoneforcats.databinding.ContentCatListItemBinding
import com.vnvj0033.allinoneforcats.model.Cat

class CatListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val catList = ArrayList<Cat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = ContentCatListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = catList[position]
        if (holder is CatViewHolder) {
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int = catList.size

    inner class CatViewHolder(private val binding: ContentCatListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cat) {
            Glide.with(binding.root)
                .load(item.imageUrl)
                .into(binding.imageviewCatItem)
        }
    }
}