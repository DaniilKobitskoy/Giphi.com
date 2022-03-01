package com.example.giphiapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.giphiapp.R
import com.example.giphiapp.model.model1.SearchGiphi

class AdapterSearch(private val context: Context, private val movieListSearch: SearchGiphi): RecyclerView.Adapter<AdapterSearch.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ImageGiphy: ImageView = itemView.findViewById(R.id.ImageGiphy)

        fun bind(movieListSearch: SearchGiphi){
        }
    }
    override fun getItemCount(): Int {
    return movieListSearch.data!!.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_giphy,parent, false)
        return MyViewHolder(itemView)

    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movieListSearch = movieListSearch.data!!.get(position)
        Glide.with(context).load(movieListSearch!!.images!!.original!!.url).into(holder.ImageGiphy)


    }
}