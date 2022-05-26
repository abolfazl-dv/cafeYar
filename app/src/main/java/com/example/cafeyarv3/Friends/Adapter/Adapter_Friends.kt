package com.example.cafeyarv3.Friends.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.Friends.Model.Model_Friends
import com.example.cafeyarv3.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by abolfazl_dv on 23,April,2022
 */
class Adapter_Friends(val context: Context ,friendsList : List<Model_Friends> ):
    RecyclerView.Adapter<Adapter_Friends.FriendsViewHolder>(){

    val friendsList : List<Model_Friends> = friendsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val friendsView = LayoutInflater.from(context).inflate(R.layout.listitem_friendslist , parent, false)
        return FriendsViewHolder(friendsView)
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        val friendsModel = friendsList[position]
        Picasso.get().load(friendsModel.image).resize(200,200).into(holder.userImage)
        holder.userName.text = friendsModel.name
        holder.userId.text = friendsModel.UserId

    }

    override fun getItemCount(): Int {
        return  friendsList.size
    }



    inner class FriendsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val userImage : CircleImageView
        val userId : TextView
        val userName : TextView
        init {
            userId = itemView.findViewById(R.id.itemListFriendsId)
            userImage = itemView.findViewById(R.id.itemListFriendsImage)
            userName = itemView.findViewById(R.id.itemListFriendsUserName)
        }
    }
}