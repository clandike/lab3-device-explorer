package com.example.testapplication.presentation.secondScreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.data.local.model.ItemModel

class FragmentFullDescription : Fragment() {

    private val itemList = ArrayList<ItemModel>()
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

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var viewModel = ViewModelProvider(this).get(FullDescriptionViewModel::class.java)
            itemList.clear()
            itemList.addAll(viewModel.getItem())
        val adapter = AdapterForFragmentFullDesc(itemList)

        val rv = view.findViewById<RecyclerView>(R.id.rvItemImages)
        rv.adapter = adapter

        val layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL,false)
        rv.layoutManager = layoutManager

        // item brand
        val tvBrand = view.findViewById<TextView>(R.id.brandItem)
        tvBrand.text = itemList.get(0).brand

        // item description
        val tvDescription = view.findViewById<TextView>(R.id.descItem)
        tvDescription.text = itemList.get(0).description
        // image change
    }
}