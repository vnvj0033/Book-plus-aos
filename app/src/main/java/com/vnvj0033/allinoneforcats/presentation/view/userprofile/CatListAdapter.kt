package com.vnvj0033.allinoneforcats.presentation.view.userprofile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.databinding.ContentCatListItemBinding
import com.vnvj0033.allinoneforcats.domain.model.Cat

class CatListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val catList = ArrayList<Cat>()

    var userProfileEvent: UserProfileEvent? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.content_cat_list_item, parent, false) as ContentCatListItemBinding
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cat = catList[position]
        if (holder is CatViewHolder) {
            holder.bind(cat)
        }
    }

    override fun getItemCount(): Int = catList.size

    fun addCats(cats: List<Cat>) {
        catList.addAll(cats)
        notifyItemRangeInserted(itemCount - cats.size, cats.size)
    }

    inner class CatViewHolder(private val binding: ContentCatListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: Cat) {
            binding.imageviewCatCatDetail.setOnClickListener { userProfileEvent?.goToCatDetail(cat) }
        }
    }
}