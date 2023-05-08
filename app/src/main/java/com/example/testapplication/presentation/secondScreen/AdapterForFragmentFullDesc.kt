package com.example.testapplication.presentation.secondScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapplication.data.local.model.ItemModel
import com.example.testapplication.databinding.ItemImageBinding

class AdapterForFragmentFullDesc(private val list: List<ItemModel>) :
    RecyclerView.Adapter<AdapterForFragmentFullDesc.ItemImageViewHolder>() {

    inner class ItemImageViewHolder(val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: ItemModel, position: Int) {
            Glide.with(binding.ivItem.context)
                .load(item.images?.get(position))
                .into(binding.ivItem)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterForFragmentFullDesc.ItemImageViewHolder {
        val view = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemImageViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: AdapterForFragmentFullDesc.ItemImageViewHolder,
        position: Int
    ) {
        holder.bindItem(list.get(0),position)
    }

    override fun getItemCount(): Int {
        return list.get(0).images!!.size
    }
}