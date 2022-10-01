package com.vnvj0033.allinoneforcats.ui.catdetil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.databinding.ContentCatListItemBinding
import com.vnvj0033.allinoneforcats.model.Cat

class CatDetailAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val item = ArrayList<Cat>()

    var catDetailEvent: CatDetailEvent? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.content_cat_list_item, parent, false) as ContentCatListItemBinding
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cat = item[position]
        if (holder is CatDetailAdapter.CatViewHolder) {
            holder.bind(cat)
        }
    }

    override fun getItemCount(): Int = item.size

    fun addData(list: List<Cat>) {
        item.addAll(list)
        notifyItemRangeInserted(itemCount - list.size, list.size)
    }

    inner class CatViewHolder(private val binding: ContentCatListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: Cat) {
            binding.imageviewCatCatDetail.setOnClickListener {
                catDetailEvent?.goToCatDetail(cat)
            }
        }

    }
}