package com.example.cafeyarv3.Courses

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.Courses.Adapter.Adapter_CoursesSpecific
import com.example.cafeyarv3.Courses.Model.Model_CoursesSpecific
import com.example.cafeyarv3.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class CoursesSpecificActivity : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        val courseList = arrayListOf<Model_CoursesSpecific>()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses_specific)
        val specificRecyclerView = findViewById<RecyclerView>(R.id.coursesSpecificRecycler)
        courseList.add(Model_CoursesSpecific(R.drawable.coldbar0 , "آموزش بار سرد" , 9 , "دانیال سلیمانی"))
        courseList.add(Model_CoursesSpecific(R.drawable.hotbar0 , "آموزش بار گرم" , 9 , "دانیال سلیمانی"))
        courseList.add(Model_CoursesSpecific(R.drawable.pie0 , "شیرینی کافه ای" , 9 , "دانیال سلیمانی"))
        courseList.add(Model_CoursesSpecific(R.drawable.mochapot0 , "قهوه خانگی" , 9 , "دانیال سلیمانی"))
        courseList.add(Model_CoursesSpecific(R.drawable.pasta0 , "پاستا" , 9 , "دانیال سلیمانی"))
        courseList.add(Model_CoursesSpecific(R.drawable.roasting0 , "رست قهوه" , 9 , "دانیال سلیمانی"))
        val courseAdapter = Adapter_CoursesSpecific(this , courseList)
        specificRecyclerView.adapter = courseAdapter
        specificRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}