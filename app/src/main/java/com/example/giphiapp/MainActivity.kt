package com.example.giphiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giphiapp.adapter.MyViewHolderGiphi
import com.example.giphiapp.common.Common
import com.example.giphiapp.model.GiphiModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


lateinit var mService: RetrofitClientGiphi
lateinit var layoutManager: LinearLayoutManager
lateinit var adapter: MyViewHolderGiphi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      mService = Common.retrofitService
        recycler_item.setLayoutManager(GridLayoutManager(this, 2))

        recycler_item.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recycler_item.layoutManager = layoutManager

        getAllMovieList()

    }

    private fun getAllMovieList() {
        mService.getAllMovieList().enqueue(object : Callback<GiphiModel>
        {
            override fun onResponse(call: Call<GiphiModel>, response: Response<GiphiModel>) {
                adapter = MyViewHolderGiphi(baseContext, response.body() as GiphiModel)
                adapter.notifyDataSetChanged()
                Log.i("TAG2", response.body().toString())
                // adapter.setOnClickListener(object : MyCustomAdapter1.onItemClickListener{
//                    override fun onItemClick(position: Int) {
//                        Toast.makeText(())
//                    }
//                })
                recycler_item.adapter = adapter

                recycler_item.layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            }

            override fun onFailure(call: Call<GiphiModel>, t: Throwable) {

                val toast = Toast.makeText(this@MainActivity, "vvvv", Toast.LENGTH_SHORT).show()

            }
        })

    }




    }
