package com.example.testapplication.presentation.first

import android.os.Bundle
import android.util.Log
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
import com.example.testapplication.data.remote.model.ItemApiModel
import com.example.testapplication.data.remote.model.Products
import retrofit2.Call
import retrofit2.Response
class FragmentMainList : Fragment() {
    private var data = ArrayList<Products>()
    lateinit var adapter: AdapterForMainList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.swipe)

        getAllProducts()

        swipe.setOnRefreshListener {
            getAllProducts()
            swipe.isRefreshing = false
        }
    }

    private fun getAllProducts() {
        val viewModel = MainListViewModel()
        viewModel.getData().enqueue(object : retrofit2.Callback<ItemApiModel> {
            override fun onResponse(call: Call<ItemApiModel>, response: Response<ItemApiModel>) {
                try {
                    // to avoid nulPointerException
                    val responseBody = response.body()!!
                    data = responseBody.products

                    adapter = AdapterForMainList(data) { data, position ->
                        Toast.makeText(requireContext(), "Click btn №$position", Toast.LENGTH_LONG)
                            .show()

                        viewModel.putItem(data.images,data.description,data.brand)

                        findNavController().navigate(R.id.mainToDescription, Bundle().apply {})
                    }
                    val rv = view?.findViewById<RecyclerView>(R.id.rv)
                    rv?.adapter = adapter

                    val layoutManager = LinearLayoutManager(context)
                    rv?.layoutManager = layoutManager

                } catch (ex: java.lang.Exception) {
                    ex.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ItemApiModel>, t: Throwable) {
                Log.e("Failed", "Api Failed" + t.message)
                Toast.makeText(requireContext(), "No Internet connection", Toast.LENGTH_LONG).show()
            }
        })
    }
}