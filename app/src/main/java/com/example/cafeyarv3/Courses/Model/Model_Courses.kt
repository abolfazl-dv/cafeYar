package com.example.cafeyarv3.Courses.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by abolfazl_dv on 02,April,2022
 */
@Parcelize
class Model_Courses (
val courseImage:Int,
val courseTitle:String,
val courseNumber :String
        ): Parcelable {
val Id :String = UUID.randomUUID().toString()
}