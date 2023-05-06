package com.example.testapplication.presentation.first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapplication.R
import com.example.testapplication.data.remote.model.Products

class AdapterForMainList(private val mList: List<Products> ) :
    RecyclerView.Adapter<AdapterForMainList.ItemViewHolder>() {

    inner class ItemViewHolder(ItemView: View) :  RecyclerView.ViewHolder(ItemView) {
        val imageView : ImageView = ItemView.findViewById(R.id.imageView)
        val nameView : TextView = ItemView.findViewById(R.id.tvName)
        val descView : TextView = ItemView.findViewById(R.id.tvDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return ItemViewHolder(view)
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val product = mList[position]
        holder.nameView.setText(product.brand)
        holder.descView.setText(product.description)
        Glide.with(holder.imageView.context)
            .load(product.images[0].toString())
            .into(holder.imageView)
    }
}