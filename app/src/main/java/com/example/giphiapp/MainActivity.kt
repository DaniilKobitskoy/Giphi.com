package com.example.giphiapp

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
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
//
val buttonSearch = findViewById<Button>(R.id.buttonSearch)
        buttonSearch.setOnClickListener {
            var editText = findViewById<EditText>(R.id.edtTxtSearch)
            var search = editText.text.toString()
            val intent = Intent(this, searchActv::class.java)
            intent.putExtra("search", search)
            startActivity(intent)
        }

      mService = Common.retrofitService
        recycler_item.setLayoutManager(GridLayoutManager(this, 2))
        recycler_item.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recycler_item.layoutManager = layoutManager
        getAllMovieList()
    }

var apikey: Any = "G15JgFWc0zCOV4JfylKfBT0T9DuOQzFJ"
    private fun getAllMovieList() {
        mService.getAllMovieList(apikey).enqueue(object : Callback<GiphiModel>
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
