package com.example.cafeyarv2.Events

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.Events.Adapter.Adapter_Events
import com.example.cafeyarv3.Events.EventDetailActivity
import com.example.cafeyarv3.Events.InvitationActivity
import com.example.cafeyarv3.Events.Listener.OnEventItemClickedListener
import com.example.cafeyarv3.Events.Model.Model_Event
import com.example.cafeyarv3.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Created by abolfazl_dv on 31,March,2022
 */
class Fragment_Events : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_events, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerEvent = view.findViewById<RecyclerView>(R.id.RecyclerEvents)

        val eventList = arrayListOf<Model_Event>()
        eventList.add(
            Model_Event(
                R.drawable.chess,
                "لیگ شطرنج",
                "کافه گیم فلان",
                "پنجشنبه 01 اسفند",
                100.000
            )
        )
        eventList.add(
            Model_Event(
                R.drawable.backgammon,
                "لیگ تخته نرد",
                "کافه خلیفه",
                "دوشنبه 12 فروردین",
                25.800
            )
        )
        eventList.add(
            Model_Event(
                R.drawable.uno,
                "بازی گروهی اونو",
                "کافه روکلانژ",
                "شنبه 23 تیر",
                43.000
            )
        )
        eventList.add(
            Model_Event(
                R.drawable.mafia,
                "ایونت شب مافیا",
                "کافه کربن",
                "جمعه 17 شهریور",
                55.000
            )
        )
        eventList.add(
            Model_Event(
                R.drawable.chess,
                "لیگ شطرنج",
                "کافه پیا",
                "چهارشنبه 29 بهمن",
                67.000
            )
        )
        eventList.add(
            Model_Event(
                R.drawable.backgammon,
                "لیگ تخته نرد",
                "کافه نو نیم",
                "یکشنبه 31 اردیبهشت",
                12.000
            )
        )
        eventList.add(
            Model_Event(
                R.drawable.uno,
                "بازی گروهی اونو",
                "کافه ران",
                "پنجشنبه 21 آذر",
                250.000
            )
        )
        eventList.add(
            Model_Event(
                R.drawable.mafia,
                "ایونت شب مافیا",
                "کافه گیم اسکواد",
                "سه شنبه 15 آبان",
                25.000
            )
        )
        eventList.add(
            Model_Event(
                R.drawable.chess,
                "لیگ شطرنج",
                "کافه اکسپوز",
                "جمعه 18 مهر",
                98.000
            )
        )
        val adapterEvent = Adapter_Events(requireContext(), eventList)
        recyclerEvent.adapter = adapterEvent
        recyclerEvent.layoutManager = LinearLayoutManager(requireContext())
        adapterEvent.setEventItemClicked(object : OnEventItemClickedListener {
            override fun onEventItemClicked(position: Int, events: Model_Event) {
                val intentToEventDetail = Intent(requireContext(),EventDetailActivity::class.java)
                intentToEventDetail.putExtra("events" , events)
                intentToEventDetail.putExtra("position" , position)
                startActivity(intentToEventDetail)

            }

        })
    }
}