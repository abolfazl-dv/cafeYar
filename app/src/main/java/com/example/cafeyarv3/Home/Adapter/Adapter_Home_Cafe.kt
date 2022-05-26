package com.example.cafeyarv3.Events.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.Events.Listener.OnEventItemClickedListener

import com.example.cafeyarv3.Home.Model.Model_Home_Cafe
import com.example.cafeyarv3.R
import com.squareup.picasso.Picasso

/**
 * Created by abolfazl_dv on 04,April,2022
 */
class Adapter_Home_Cafe(var context: Context, cafeList: List<Model_Home_Cafe>) :
    RecyclerView.Adapter<Adapter_Home_Cafe.eventViewHolder>() {

    val cafeList: List<Model_Home_Cafe> = cafeList
    var onEventItemClickedListener : OnEventItemClickedListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapter_Home_Cafe.eventViewHolder {
        val eventView =
            LayoutInflater.from(context).inflate(R.layout.itemlist_homepagecafes, parent, false)
        return eventViewHolder(eventView)
    }

    override fun onBindViewHolder(holder: Adapter_Home_Cafe.eventViewHolder, position: Int) {
        val eventModel = cafeList[position]
        Picasso.get().load(eventModel.cafeImage).resize(250 , 500).into(holder.cafeImage)
        holder.cafeName.text = eventModel.cafeName
        holder.cafeDistance.text = eventModel.cafeDistance
        holder.cafeRate.text = eventModel.cafeRate.toString()
        holder.cafeComment.text = eventModel.cafeComment
//        holder.itemView.setOnClickListener {
//            Toast.makeText(context, "you clicked item ${position}" , Toast.LENGTH_SHORT ).show()
//            onEventItemClickedListener?.onEventItemClicked(position,eventModel)
//        }
    }

    override fun     getItemCount(): Int {
        return cafeList.size
    }

    inner class eventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cafeImage: ImageView
        val cafeName: TextView
        val cafeRate: TextView
        val cafeDistance: TextView
        val cafeComment: TextView

        init {
            cafeImage = itemView.findViewById(R.id.itemListHomeCafeImage)
            cafeName = itemView.findViewById(R.id.itemListHomeCafeName)
            cafeRate = itemView.findViewById(R.id.itemListHomeCafeRate)
            cafeDistance = itemView.findViewById(R.id.itemListHomeCafeDistance)
            cafeComment = itemView.findViewById(R.id.itemListHomeCafeComment)
        }
    }
    fun setEventItemClicked(onEventItemClickedListener: OnEventItemClickedListener){
        this.onEventItemClickedListener = onEventItemClickedListener
    }
}