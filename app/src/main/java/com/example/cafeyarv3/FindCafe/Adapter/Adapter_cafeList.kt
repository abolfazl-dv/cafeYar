package com.example.cafeyarv3.FindCafe.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.CafeDetail.CafeDetailActivity
import com.example.cafeyarv3.FindCafe.Model.Model_cafeList
import com.example.cafeyarv3.R
import com.squareup.picasso.Picasso
import com.willy.ratingbar.ScaleRatingBar
import android.app.Activity




/**
 * Created by abolfazl_dv on 18,April,2022
 */
class Adapter_cafeList(var context: Context, cafeList: List<Model_cafeList>) :
    RecyclerView.Adapter<Adapter_cafeList.cafeListViewHolder>() {

    val cafeList: List<Model_cafeList> = cafeList


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapter_cafeList.cafeListViewHolder {
        val cafeListView =
            LayoutInflater.from(context).inflate(R.layout.listitem_cafeonlist, parent, false)
        return cafeListViewHolder(cafeListView)
    }

    override fun onBindViewHolder(holder: Adapter_cafeList.cafeListViewHolder, position: Int) {
        val cafeListModel = cafeList[position]
        Picasso.get().load(cafeListModel.cafeImage).resize(400 , 200).into(holder.cafeImage)
        holder.cafename.text = cafeListModel.cafeName
        holder.cafeAddress.text = cafeListModel.cafeAddress
        holder.itemView.setOnClickListener {
            val intent = Intent(context , CafeDetailActivity::class.java)
            context.startActivity(intent)
            (context as Activity).finish()
        }
    }

    override fun getItemCount(): Int {
        return cafeList.size
    }

    inner class cafeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cafename : TextView
        val cafeImage : ImageView
        val cafeRate : ScaleRatingBar
        val cafeAddress : TextView
        init {
            cafename = itemView.findViewById(R.id.listItemCafeListName)
            cafeImage = itemView.findViewById(R.id.listItemCafeListImage)
            cafeRate = itemView.findViewById(R.id.listItemCafeListRating)
            cafeAddress = itemView.findViewById(R.id.listItemCafeListAddress)
        }
    }
}