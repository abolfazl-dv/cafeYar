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
import com.example.cafeyarv3.Events.Model.Model_Event
import com.example.cafeyarv3.R
import com.squareup.picasso.Picasso

/**
 * Created by abolfazl_dv on 04,April,2022
 */
class Adapter_Events(var context: Context, eventList: List<Model_Event>) :
    RecyclerView.Adapter<Adapter_Events.eventViewHolder>() {

    val eventList: List<Model_Event> = eventList
    var onEventItemClickedListener : OnEventItemClickedListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapter_Events.eventViewHolder {
        val eventView =
            LayoutInflater.from(context).inflate(R.layout.listitem_events, parent, false)
        return eventViewHolder(eventView)
    }

    override fun onBindViewHolder(holder: Adapter_Events.eventViewHolder, position: Int) {
        val eventModel = eventList[position]
        Picasso.get().load(eventModel.eventImage).into(holder.eventImage)
        holder.eventTime.text = eventModel.eventTime
        holder.eventOrganizer.text = eventModel.eventOrganizer
        holder.eventCharge.text = eventModel.eventCharge.toString()
        holder.eventTitle.text = eventModel.eventTitle
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "you clicked item ${position}" , Toast.LENGTH_SHORT ).show()
            onEventItemClickedListener?.onEventItemClicked(position,eventModel)
        }
    }

    override fun     getItemCount(): Int {
        return eventList.size
    }

    inner class eventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventImage: ImageView
        val eventTitle: TextView
        val eventOrganizer: TextView
        val eventCharge: TextView
        val eventTime: TextView

        init {
            eventImage = itemView.findViewById(R.id.ItemListEventsImage)
            eventCharge = itemView.findViewById(R.id.ItemListEventsEntryAmount)
            eventTitle = itemView.findViewById(R.id.ItemListEventsTitle)
            eventOrganizer = itemView.findViewById(R.id.ItemListEventsOrganizer)
            eventTime = itemView.findViewById(R.id.ItemListEventsTime)
        }
    }
    fun setEventItemClicked(onEventItemClickedListener: OnEventItemClickedListener){
        this.onEventItemClickedListener = onEventItemClickedListener
    }
}