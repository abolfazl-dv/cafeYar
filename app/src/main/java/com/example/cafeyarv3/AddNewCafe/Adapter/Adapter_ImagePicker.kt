package com.example.cafeyarv3.AddNewCafe.Adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.R
import com.squareup.picasso.Picasso

/**
 * Created by abolfazl_dv on 05,April,2022
 */
class Adapter_ImagePicker(var context: Context, uriArrayList: ArrayList<Uri>) :
    RecyclerView.Adapter<Adapter_ImagePicker.imagePickerViewHolder>() {
    val uriArrayList: ArrayList<Uri> = uriArrayList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): imagePickerViewHolder {
        val imagesView = LayoutInflater.from(context)
            .inflate(R.layout.listitem_newcafe_imagepicker, parent, false)
        return imagePickerViewHolder(imagesView)
    }

    override fun onBindViewHolder(holder: imagePickerViewHolder, position: Int) {
        Picasso.get().load(uriArrayList[position]).resize(100 , 60).into(holder.cafeImage)
        holder.itemView.setOnClickListener {
            uriArrayList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return uriArrayList.size
    }

    inner class imagePickerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cafeImage: ImageView

        init {
            cafeImage = itemView.findViewById(R.id.listItemNewCafeImage)

        }
    }

}