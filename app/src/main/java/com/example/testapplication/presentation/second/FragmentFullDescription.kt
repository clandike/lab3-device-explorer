package com.example.testapplication.presentation.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.testapplication.R

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
        // text change
        val tv = view.findViewById<TextView>(R.id.descriptionCar)
        tv.text = requireArguments().getString("description")

        // image change
        val iv = view.findViewById<ImageView>(R.id.imageCar)
        Glide.with(iv.context)
            .load(requireArguments().getString("imageURL"))
            .into(iv)
    }

}