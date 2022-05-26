package com.example.cafeyarv3.Comment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.Comment.Model.Model_CommentList
import com.example.cafeyarv3.R
import com.squareup.picasso.Picasso

/**
 * Created by abolfazl_dv on 12,May,2022
 */
class Adapter_CommentList(var context: Context, commentList: List<Model_CommentList>) :
    RecyclerView.Adapter<Adapter_CommentList.commentViewHolder>() {

    val commentList: List<Model_CommentList> = commentList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): commentViewHolder {
        val commentView =
            LayoutInflater.from(context).inflate(R.layout.itemlist_comment, parent, false)
        return commentViewHolder(commentView)
    }

    override fun onBindViewHolder(holder: commentViewHolder, position: Int) {
        val commentModel = commentList[position]
        Picasso.get().load(commentModel.userImage).resize(60 , 60).into(holder.userImage)
        holder.userName.text = commentModel.userName
        holder.userRated.text = commentModel.userRated
        holder.commentText.text = commentModel.commentText
        holder.commentPublishedDate.text = commentModel.commentPublishedDate
        holder.commentPublishedDateText.text = commentModel.commentPublishedDateText
    }

    override fun getItemCount(): Int {
        return commentList.size
    }


    inner class commentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage: ImageView
        val userName: TextView
        val commentPublishedDate: TextView
        val commentText: TextView
        val userRated: TextView
        val commentPublishedDateText: TextView

        init {
            userImage = itemView.findViewById(R.id.itemListCommentUserImage)
            userName = itemView.findViewById(R.id.itemListCommentUserName)
            commentPublishedDate = itemView.findViewById(R.id.itemListCommentDateNumber)
            commentText = itemView.findViewById(R.id.itemListComment)
            userRated = itemView.findViewById(R.id.itemListCommentRate)
            commentPublishedDateText = itemView.findViewById(R.id.itemListCommentDateText)
        }
    }
}