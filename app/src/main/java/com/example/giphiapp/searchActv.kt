package com.example.giphiapp

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.giphiapp.adapter.AdapterSearch
import com.example.giphiapp.common.Common1
import com.example.giphiapp.model.model1.SearchGiphi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search_actv.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var mService1: RefrofitClientSearch
lateinit var layoutManager1: LinearLayoutManager

lateinit var adapter3: AdapterSearch

class searchActv : AppCompatActivity() {
    lateinit var q: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_actv)

        mService1 = Common1.retrofitService
        recycler_item1.setLayoutManager(GridLayoutManager(this, 2))
        recycler_item1.setHasFixedSize(true)
        layoutManager1 = LinearLayoutManager(this)
        recycler_item1.layoutManager = layoutManager1



        var q1: String = intent.getStringExtra("giphy")!!


        getAllMovieList1()



    }

//var search = intent.extras!!.getString("search")

//    var q1: String = intent.getStringExtra("giphy")!!

//СЮДА МНЕ НУЖНО ПЕРЕДАТЬ ТЕКСТ ИЗ EDITTEXT И ВСТАВИТЬ ЕГО В ПАРАМЕТР ЗАПРОСА, ВОТ ГДЕ q  (q = "Happy birthday") - это и есть параметр
    var apikey: String = "G15JgFWc0zCOV4JfylKfBT0T9DuOQzFJ"
    private fun getAllMovieList1() {
        mService1.getAllMovieList123(apikey, q = "Happy birthday").enqueue(object : Callback<SearchGiphi> {
            override fun onResponse(call: Call<SearchGiphi>, response: Response<SearchGiphi>) {
                adapter3 = AdapterSearch(baseContext, response.body() as SearchGiphi)
                adapter3.notifyDataSetChanged()
                Log.i("TAG2", response.body().toString())

                // adapter.setOnClickListener(object : MyCustomAdapter1.onItemClickListener{
//                    override fun onItemClick(position: Int) {
//                        Toast.makeText(())
//                    }
//                })
                recycler_item1.adapter = adapter3

                recycler_item1.layoutManager =
                    LinearLayoutManager(this@searchActv, LinearLayoutManager.VERTICAL, false)
            }

            override fun onFailure(call: Call<SearchGiphi>, t: Throwable) {

                val toast = Toast.makeText(this@searchActv, "vvvv", Toast.LENGTH_SHORT).show()

            }
        })

    }
}













































//             mService1 = Common1.retrofitService
//        recycler_item1.setLayoutManager(GridLayoutManager(this, 2))
//
//        recycler_item1.setHasFixedSize(true)
//        layoutManager = LinearLayoutManager(this)
//        recycler_item1.layoutManager = layoutManager
//
//        getAllMovieList1()






//    var apikey: Any = "G15JgFWc0zCOV4JfylKfBT0T9DuOQzFJ&q"
//    private fun getAllMovieList1() {
//        mService1.getAllMovieList123(  apikey.toString()).enqueue(object : Callback<SearchGiphi>
//        {
//            override fun onResponse(call: Call<SearchGiphi>, response: Response<SearchGiphi>) {
//                adapter1 = MyViewHolderSearch(baseContext, response.body() as SearchGiphi)
//                adapter1.notifyDataSetChanged()
//                Log.i("TAG2", response.body().toString())
//                Log.i("TAG3", println().toString())
//                // adapter.setOnClickListener(object : MyCustomAdapter1.onItemClickListener{
////                    override fun onItemClick(position: Int) {
////                        Toast.makeText(())
////                    }
////                })
//                recycler_item1.adapter = adapter1
//
//                recycler_item1.layoutManager =
//                    LinearLayoutManager(this@searchActv, LinearLayoutManager.VERTICAL, false)
//            }
//
//            override fun onFailure(call: Call<SearchGiphi>, t: Throwable) {
//
//                val toast = Toast.makeText(this@searchActv, "vvvv", Toast.LENGTH_SHORT).show()
//
//            }
//        })
//
//    }
