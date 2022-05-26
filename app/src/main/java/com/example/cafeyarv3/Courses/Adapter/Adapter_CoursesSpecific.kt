package com.example.cafeyarv3.Courses.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.Courses.Model.Model_CoursesSpecific
import com.example.cafeyarv3.R
import com.squareup.picasso.Picasso

/**
 * Created by abolfazl_dv on 19,April,2022
 */
class Adapter_CoursesSpecific(var context: Context, coursesList: List<Model_CoursesSpecific>) :
    RecyclerView.Adapter<Adapter_CoursesSpecific.coursesViewHolder>() {

    val coursesList: List<Model_CoursesSpecific> = coursesList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): coursesViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.listitem_courses_specific, parent, false)
        return coursesViewHolder(view)
    }

    override fun onBindViewHolder(holder: coursesViewHolder, position: Int) {
        val courseModel = coursesList[position]
        Picasso.get().load(courseModel.courseImage).resize(350,200).into(holder.courseImage)
        holder.courseInstructor.text = courseModel.courseInstructor
        holder.courseDuration.text = courseModel.courseDuration.toString()
        holder.courseTitle.text = courseModel.courseTitle
    }

    override fun getItemCount(): Int {
        return coursesList.size
    }

    inner class coursesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseImage: ImageView
        val courseTitle: TextView
        val courseDuration: TextView
        val courseInstructor: TextView

        init {
           courseImage = itemView.findViewById(R.id.itemListSpecificImage)
            courseTitle = itemView.findViewById(R.id.itemListSpecificTitle)
            courseDuration = itemView.findViewById(R.id.itemListSpecificHourNumber)
            courseInstructor = itemView.findViewById(R.id.itemListSpecificInstructor)
        }
    }
}