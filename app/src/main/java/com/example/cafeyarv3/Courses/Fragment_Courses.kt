package com.example.cafeyarv2.Courses

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.Courses.Adapter.Adapter_Courses
import com.example.cafeyarv3.Courses.CoursesDetailActivity
import com.example.cafeyarv3.Courses.CoursesSpecificActivity
import com.example.cafeyarv3.Courses.Listener.OnCourseItemClickedListener
import com.example.cafeyarv3.Courses.Model.Model_Courses

import com.example.cafeyarv3.R

/**
 * Created by abolfazl_dv on 31,March,2022
 */
class Fragment_Courses : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_courses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val courseList = arrayListOf<Model_Courses>()
        val courseRecycle = view.findViewById<RecyclerView>(R.id.coursesRecycler)
        courseList.add(Model_Courses(R.drawable.coldbar0, "آموزش بار سرد", "16 دوره"))
        courseList.add(Model_Courses(R.drawable.hotbar0, "آموزش بار گرم", "21 دوره"))
        courseList.add(Model_Courses(R.drawable.barista0, "ورکشاپ باریستایی", "36 دوره"))
        courseList.add(Model_Courses(R.drawable.roasting0, "قهوه شناسی ، دیفکت ، رست", "12 دوره"))
        courseList.add(Model_Courses(R.drawable.experience0, "تجربیات کافه داری", "23 دوره"))
        courseList.add(Model_Courses(R.drawable.coffeinhome0, "قهوه تو خونه", "19 دوره"))
        courseList.add(Model_Courses(R.drawable.equipment0, "آشنایی با تجهیزات کافه", "1 دوره"))
        courseList.add(Model_Courses(R.drawable.mochapot0, "انواع قهوه دمی", "20 دوره"))
        courseList.add(Model_Courses(R.drawable.pie0, "آموزش شیرینی کافه", "5 دوره"))
        courseList.add(Model_Courses(R.drawable.pasta0, "آموزش غذای کافه", "12 دوره"))
        val coursesAdapter = Adapter_Courses(requireContext(), courseList)
        courseRecycle.adapter = coursesAdapter
        courseRecycle.layoutManager = LinearLayoutManager(requireContext())
        coursesAdapter.setCourseItemClicked(object : OnCourseItemClickedListener {
            override fun onCourseItemClicked(position: Int, courses: Model_Courses) {
                val intentToCourseDetail =
                    Intent(requireContext(), CoursesSpecificActivity::class.java)
                intentToCourseDetail.putExtra("courses", courses)
                intentToCourseDetail.putExtra("position", position)
                startActivity(intentToCourseDetail)
            }
        })
    }
}