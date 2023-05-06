package com.example.testapplication.presentation.first

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.data.remote.ApiFactory
import com.example.testapplication.data.remote.ItemApiInterface
import com.example.testapplication.data.remote.model.CarApiModel
import com.example.testapplication.data.remote.model.Products
import retrofit2.Call
import retrofit2.Response


class FragmentMainList : Fragment() {
    private var data = ArrayList<Products>()
    lateinit var viewModel: MainListViewModel

    val args: Fragment by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllProducts()
        val rv = view.findViewById<RecyclerView>(R.id.rv)
        val layoutManager = LinearLayoutManager(context)
        rv.layoutManager = layoutManager
    }

    private fun getAllProducts() {
        val retrofit = ApiFactory.buildService(ItemApiInterface::class.java)
        retrofit.getItems().enqueue(object : retrofit2.Callback<CarApiModel> {

            override fun onResponse(call: Call<CarApiModel>, response: Response<CarApiModel>) {
                try {
                    // to avoid nulPointerException
                    val responseBody = response.body()!!
                    data = responseBody.products

                    var adapter = AdapterForMainList(data)
                    val rv = view?.findViewById<RecyclerView>(R.id.rv)
                    rv?.adapter = adapter

                } catch(ex: java.lang.Exception) {
                    ex.printStackTrace()
                }
            }

            override fun onFailure(call: Call<CarApiModel>, t: Throwable) {
                Log.e("Failed", "Api Failed" + t.message)
            }

        })
    }

}