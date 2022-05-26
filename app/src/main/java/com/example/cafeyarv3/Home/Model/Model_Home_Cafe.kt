package com.example.cafeyarv3.Home.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by abolfazl_dv on 04,April,2022
 */
@Parcelize
class Model_Home_Cafe(
val cafeImage : Int,
val cafeName: String,
val cafeRate : Double,
val cafeDistance : String,
val cafeComment : String
) : Parcelable {
    val Id =UUID.randomUUID().toString()
}