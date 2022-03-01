package com.example.giphiapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.giphiapp.R
import com.example.giphiapp.model.GiphiModel
import com.example.giphiapp.model.model1.SearchGiphi

class MyViewHolderSearch(private val context: Context, private val movieList1: SearchGiphi): RecyclerView.Adapter<MyViewHolderSearch.MyViewHolder1>() {
    class MyViewHolder1(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ImageGiphy: ImageView = itemView.findViewById(R.id.ImageGiphy)

        fun bind(movieList: SearchGiphi){

        }

    }

    override fun getItemCount(): Int {

        return movieList1.data!!.count()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder1 {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_giphy,  parent, false)

        return MyViewHolder1(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder1, position: Int) {
        val movieList = movieList1.data!!.get(position)
        Glide.with(context).load(movieList!!.images!!.original!!.url).into(holder.ImageGiphy)
    }
}