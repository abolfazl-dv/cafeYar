package com.example.cafeyarv3.Events.Listener

import com.example.cafeyarv3.Events.Model.Model_Event

/**
 * Created by abolfazl_dv on 04,April,2022
 */
interface OnEventItemClickedListener {
    fun onEventItemClicked(position : Int , events : Model_Event)
}