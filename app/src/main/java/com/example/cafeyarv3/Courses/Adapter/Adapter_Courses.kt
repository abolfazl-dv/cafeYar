package com.example.cafeyarv3.Courses.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.Courses.Listener.OnCourseItemClickedListener
import com.example.cafeyarv3.Courses.Model.Model_Courses
import com.example.cafeyarv3.R
import com.squareup.picasso.Picasso

/**
 * Created by abolfazl_dv on 02,April,2022
 */
class Adapter_Courses(var context: Context, courseList: List<Model_Courses>) :
    RecyclerView.Adapter<Adapter_Courses.coursesViewHolder>() {
    val courseList: List<Model_Courses> = courseList
    var onCourseItemClickListener: OnCourseItemClickedListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): coursesViewHolder {
        val coursesView =
            LayoutInflater.from(context).inflate(R.layout.listitem_courses, parent, false)
        return coursesViewHolder(coursesView)
    }

    override fun onBindViewHolder(holder: coursesViewHolder, position: Int) {
        val coursesModel = courseList[position]
        Picasso.get().load(coursesModel.courseImage).resize(200, 200).into(holder.coursesImage)
        holder.coursesNumber.text = coursesModel.courseNumber
        holder.coursesTitle.text = coursesModel.courseTitle
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "you clicked this item " , Toast.LENGTH_SHORT).show()
            onCourseItemClickListener?.onCourseItemClicked(position, coursesModel)
        }
    }

    override fun getItemCount(): Int {
        return courseList.size
    }


    inner class coursesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coursesTitle: TextView
        val coursesNumber: TextView
        val coursesImage: ImageView

        init {
            coursesTitle = itemView.findViewById(R.id.listItemCourseTitle)
            coursesNumber = itemView.findViewById(R.id.listItemCourseNumber)
            coursesImage = itemView.findViewById(R.id.listItemCourseImage)
        }
    }

    fun setCourseItemClicked(onCourseItemClickedListener: OnCourseItemClickedListener) {
        this.onCourseItemClickListener = onCourseItemClickedListener
    }
}