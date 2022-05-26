package com.example.cafeyarv3.Courses.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by abolfazl_dv on 19,April,2022
 */
@Parcelize
class Model_CoursesSpecific(
    val courseImage : Int,
    val courseTitle : String,
    val courseDuration : Int,
    val courseInstructor : String

) : Parcelable {
    val Id = UUID.randomUUID().toString()
}