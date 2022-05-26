package com.example.cafeyarv3.Courses.Listener

import com.example.cafeyarv3.Courses.Model.Model_Courses

/**
 * Created by abolfazl_dv on 02,April,2022
 */
interface OnCourseItemClickedListener {
    fun onCourseItemClicked(position : Int , courses : Model_Courses)
}