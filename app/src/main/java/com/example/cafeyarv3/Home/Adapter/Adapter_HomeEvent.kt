package com.example.cafeyarv3.Home.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.Home.Model.Model_HomeEvent
import com.example.cafeyarv3.R
import com.squareup.picasso.Picasso

/**
 * Created by abolfazl_dv on 19,May,2022
 */
class Adapter_HomeEvent(var context: Context, eventList: List<Model_HomeEvent>) :
    RecyclerView.Adapter<Adapter_HomeEvent.homeEventViewHolder>() {

    val eventList: List<Model_HomeEvent> = eventList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): homeEventViewHolder {
        val eventView =
            LayoutInflater.from(context).inflate(R.layout.itemlist_homepage_events, parent, false)
        return homeEventViewHolder(eventView)
    }

    override fun onBindViewHolder(holder: homeEventViewHolder, position: Int) {
        val eventModel = eventList[position]
        Picasso.get().load(eventModel.image).resize(240 , 130).into(holder.image)
        holder.date.text = eventModel.date
        holder.organizer.text = eventModel.organizer
        holder.title.text = eventModel.title

    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    inner class homeEventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView
        val title: TextView
        val organizer: TextView
        val date: TextView

        init {
            image = itemView.findViewById(R.id.itemListHomeEventImage)
            title = itemView.findViewById(R.id.itemListHomeEventTitle)
            organizer = itemView.findViewById(R.id.itemListHomeEventOrganizer)
            date = itemView.findViewById(R.id.itemListHomeEventDate)
        }
    }
}