package com.vnvj0033.allinoneforcats.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vnvj0033.allinoneforcats.databinding.ContentCatListItemBinding
import com.vnvj0033.allinoneforcats.model.Cat

class CatListAdapter(private val userProfileEvent: UserProfileEvent) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val catList = ArrayList<Cat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = ContentCatListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cat = catList[position]
        if (holder is CatViewHolder) {
            holder.bind(cat)
        }
    }

    override fun getItemCount(): Int = catList.size

    fun addCat(cats: List<Cat>) {
        val positionStart = itemCount
        catList.addAll(cats)
        notifyItemRangeInserted(positionStart, cats.size)
    }

    inner class CatViewHolder(private val binding: ContentCatListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: Cat) {
            binding.imageviewCatCatDetail.setOnClickListener { userProfileEvent.goToCatDetail(cat) }
        }
    }
}