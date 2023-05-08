package com.example.testapplication.presentation.firstScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.testapplication.R
import com.example.testapplication.data.remote.model.Products

class FragmentMainList : Fragment() {
    private var data = ArrayList<Products>()
    lateinit var adapter: AdapterForMainList
    private var viewModel = MainListViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getProducts()
        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.swipe)
        swipe.setOnRefreshListener {
            getProducts()
            swipe.isRefreshing = false
        }
    }

    private fun getProducts() {
        viewModel = MainListViewModel()

        viewModel.getData()

        viewModel.items.observe(viewLifecycleOwner) {
            data.clear()
            data.addAll(it!!.products)
        }

        if (data.isEmpty()) {
            Toast.makeText(context, "No Internet!", Toast.LENGTH_SHORT).show()
        }

        adapter = AdapterForMainList(data) { data, position ->
            viewModel.putItem(data.images, data.description, data.brand)
            findNavController().navigate(R.id.mainToDescription, Bundle().apply {})
        }

        val rv = view?.findViewById<RecyclerView>(R.id.rv)
        rv?.adapter = adapter

        val layoutManager = LinearLayoutManager(context)
        rv?.layoutManager = layoutManager
    }
}