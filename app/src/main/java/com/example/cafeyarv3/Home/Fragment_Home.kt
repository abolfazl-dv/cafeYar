package com.example.cafeyarv2.FindCafe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.CafeDetail.Adapter.AdapterCafeDetailSlider
import com.example.cafeyarv3.Events.Adapter.Adapter_Events
import com.example.cafeyarv3.Events.Adapter.Adapter_Home_Cafe
import com.example.cafeyarv3.Events.Model.Model_Event
import com.example.cafeyarv3.GlideImageLoadingService
import com.example.cafeyarv3.Home.Adapter.Adapter_HomeEvent
import com.example.cafeyarv3.Home.Model.Model_HomeEvent
import com.example.cafeyarv3.Home.Model.Model_Home_Cafe
import com.example.cafeyarv3.R
import ss.com.bannerslider.Slider

/**
 * Created by abolfazl_dv on 31,March,2022
 */
class Fragment_Home : Fragment() {

    private val nearCafeList = arrayListOf<Model_Home_Cafe>()
    private val eventList = arrayListOf<Model_HomeEvent>()
    private val discountCafeList = arrayListOf<Model_Home_Cafe>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val suggestedRecycler = view.findViewById<RecyclerView>(R.id.homeSuggestedRecycler)
        val importantEventRecycler = view.findViewById<RecyclerView>(R.id.homeImportantEventRecycler)
        val discountRecycler = view.findViewById<RecyclerView>(R.id.homeDiscountRecycler)
        //
        nearCafeList.add(Model_Home_Cafe(R.drawable.alef , "کافه الف", 4.2 , "9" , "14"))
        nearCafeList.add(Model_Home_Cafe(R.drawable.cafe3 , "کافه شماره 2", 4.8 , "12" , "16"))
        nearCafeList.add(Model_Home_Cafe(R.drawable.cafe4 , "کافه شماره 3", 4.6 , "1" , "10"))
        nearCafeList.add(Model_Home_Cafe(R.drawable.cafe5 , "4", 4.0 , "0.4" , "23"))
        nearCafeList.add(Model_Home_Cafe(R.drawable.cafe2 , "کافه شماره 5", 3.8 , "6" , "5"))
        //
        eventList.add(Model_HomeEvent(R.drawable.cafe4 , "کافه اکسپرسو" , "اجرای زنده سندی" , "دوشنبه 6 خرداد"))
        eventList.add(Model_HomeEvent(R.drawable.cafe2 , "کافه کربن" , "پخش زنده فوتبال" , "یکشنبه 17 تیر"))
        eventList.add(Model_HomeEvent(R.drawable.cafe5 , "کافه ران" , "بازی گروهی مافیا" , "شنبه 1 بهمن"))
        eventList.add(Model_HomeEvent(R.drawable.cafe3 , "کافه نو نیم" , "شب نشینی سینمایی" , "جمعه 12 اردیبهشت"))
        eventList.add(Model_HomeEvent(R.drawable.cafe5 , "کافه رنجی" , "اجرای زنده هنگ درام" , "دوشنبه 19 مرداد"))
        eventList.add(Model_HomeEvent(R.drawable.cafe2 , "کافه ماژورل" , "گردهمایی خودرو های کلاسیک" , "پنجشنبه 11 خرداد"))
        eventList.add(Model_HomeEvent(R.drawable.cafe3 , "کافه یوتا" , "نقد و بررسی فیلم" , "سه شنبه 28 مهر"))
         //
        discountCafeList.add(Model_Home_Cafe(R.drawable.alef , "کافه ران", 4.2 , "9" , "14"))
        discountCafeList.add(Model_Home_Cafe(R.drawable.cafe5 , "کافه اکسپرسو", 4.2 , "9" , "14"))
        discountCafeList.add(Model_Home_Cafe(R.drawable.cafe2 , "کافه کربن", 4.2 , "9" , "14"))
        discountCafeList.add(Model_Home_Cafe(R.drawable.cafe4 , "کافه یوتا", 4.2 , "9" , "14"))
        discountCafeList.add(Model_Home_Cafe(R.drawable.cafe3 , "کافه نو نیم", 4.2 , "9" , "14"))
        discountCafeList.add(Model_Home_Cafe(R.drawable.cafe5 , "کافه ماژورل", 4.2 , "9" , "14"))
        //
        val nearCafeListAdapter = Adapter_Home_Cafe(requireContext() , nearCafeList)
        val eventListAdapter  = Adapter_HomeEvent(requireContext(), eventList)
        val discountCafeListAdapter  = Adapter_Home_Cafe(requireContext(), discountCafeList)
        //
        val eventLayoutManager = LinearLayoutManager(requireContext() , RecyclerView.HORIZONTAL , false )
        eventLayoutManager.reverseLayout = true
        val suggestLayoutManager = LinearLayoutManager(requireContext() , RecyclerView.HORIZONTAL , false )
        suggestLayoutManager.reverseLayout = true
        val discountLayoutManager = LinearLayoutManager(requireContext() , RecyclerView.HORIZONTAL , false )
        discountLayoutManager.reverseLayout = true
        //
        suggestedRecycler.adapter = nearCafeListAdapter
        suggestedRecycler.layoutManager = suggestLayoutManager
        //
        importantEventRecycler.adapter = eventListAdapter
        importantEventRecycler.layoutManager =eventLayoutManager
        //
        discountRecycler.adapter = discountCafeListAdapter
        discountRecycler.layoutManager = discountLayoutManager

    }
}