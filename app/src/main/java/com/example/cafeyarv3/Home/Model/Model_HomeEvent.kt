package com.example.cafeyarv3.Home.Model

import java.util.*

/**
 * Created by abolfazl_dv on 19,May,2022
 */
class Model_HomeEvent(
    val image: Int,
    val organizer : String,
    val title : String,
    val date : String
) {
    val id = UUID.randomUUID().toString()
}