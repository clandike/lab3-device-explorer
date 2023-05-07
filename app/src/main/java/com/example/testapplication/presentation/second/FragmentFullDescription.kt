package com.example.testapplication.presentation.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.testapplication.R
import com.example.testapplication.data.local.model.ItemModel

class FragmentFullDescription : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val viewModel = FullDescriptionViewModel()
        var itemList = ArrayList<ItemModel>()
        itemList.clear()
        itemList.addAll(viewModel.getItem())

        // text change
        val tv = view.findViewById<TextView>(R.id.descriptionCar)
        tv.text = itemList.get(0).description

        var itemImages = ArrayList<String>()
        itemImages.addAll(itemList.get(0).images!!)

        // image change
        val iv = view.findViewById<ImageView>(R.id.imageCar)
        Glide.with(iv.context)
            .load(itemImages[0])
            .into(iv)
    }

}