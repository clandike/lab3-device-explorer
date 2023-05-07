package com.example.testapplication.presentation.first

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapplication.data.remote.model.Products
import com.example.testapplication.databinding.ItemCarBinding

class AdapterForMainList(private val mList: List<Products>, val onClick: (item: Products, position: Int) -> Unit) :
    RecyclerView.Adapter<AdapterForMainList.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: Products, position: Int) {
            binding.tvName.text = item.brand
            binding.tvDesc.text = item.title

            binding.btn.setOnClickListener {
                onClick(item, position)
            }

            Glide.with(binding.imageView.context)
                .load(item.images[0])
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindItem(mList[position],position)
    }
}