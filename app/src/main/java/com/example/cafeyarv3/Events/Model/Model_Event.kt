package com.example.cafeyarv3.Events.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by abolfazl_dv on 04,April,2022
 */
@Parcelize
class Model_Event(
val eventImage : Int,
val eventTitle: String,
val eventOrganizer : String,
val eventTime : String,
val eventCharge : Double
) : Parcelable {
    val Id =UUID.randomUUID().toString()
}