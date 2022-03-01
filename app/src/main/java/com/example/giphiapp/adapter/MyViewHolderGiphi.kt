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

class MyViewHolderGiphi(private val context: Context, private val movieList: GiphiModel): RecyclerView.Adapter<MyViewHolderGiphi.MyViewHolder>() {


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
val ImageGiphy: ImageView = itemView.findViewById(R.id.ImageGiphy)

fun bind(movieList: GiphiModel){

}



    }


    override fun getItemCount(): Int {

        return movieList.data!!.count()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView1 = LayoutInflater.from(parent.context).inflate(R.layout.item_giphy,  parent, false)

        return MyViewHolder(itemView1)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movieList = movieList.data!!.get(position)
        Glide.with(context).load(movieList!!.images!!.original!!.url).into(holder.ImageGiphy)
    }
}