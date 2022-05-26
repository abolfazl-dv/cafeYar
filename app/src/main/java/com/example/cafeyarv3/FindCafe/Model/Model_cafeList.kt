package com.example.cafeyarv3.FindCafe.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by abolfazl_dv on 18,April,2022
 */
@Parcelize
class Model_cafeList(
    val cafeImage :Int,
    val cafeName: String,
    val cafeAddress : String
) : Parcelable {
    val Id = UUID.randomUUID().toString()
}