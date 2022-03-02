package com.example.giphiapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.giphiapp.adapter.MyViewHolderGiphi
import com.example.giphiapp.common.Common
import com.example.giphiapp.model.GiphiModel
import com.example.giphiapp.searchActv.Companion.SEARCH_KEY
import kotlinx.android.synthetic.main.activity_giphy.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.StringReader

lateinit var mService: RetrofitClientGiphi
lateinit var layoutManager: LinearLayoutManager
lateinit var adapter: MyViewHolderGiphi

class GiphyAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giphy)
        var editText = findViewById<EditText>(R.id.edtText)

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
                recycler_item.adapter = adapter
                recycler_item.layoutManager =
                    LinearLayoutManager(this@GiphyAct, LinearLayoutManager.VERTICAL, false)
            }
            override fun onFailure(call: Call<GiphiModel>, t: Throwable) {
                val toast = Toast.makeText(this@GiphyAct, "vvvv", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun goToNewView(view: View) {
        when (view.getId()) {
            R.id.buttonSearch1 -> {

                if (edtText.length() > 0){
                val intent = Intent(this, searchActv::class.java)
                val editText = findViewById<EditText>(R.id.edtText)
                intent.putExtra(SEARCH_KEY, editText.text.toString())
                startActivity(intent)
                }
                else{
                    val toast = Toast.makeText(this@GiphyAct, "Строка поиска пустая", Toast.LENGTH_SHORT).show()

                }
            }
            else -> {
            }
        }


    }
}