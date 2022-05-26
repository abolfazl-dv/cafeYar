package com.example.cafeyarv3.FindCafe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.Filter.Fragment_Search_Filter
import com.example.cafeyarv3.FindCafe.Adapter.Adapter_cafeList
import com.example.cafeyarv3.FindCafe.Model.Model_cafeList
import com.example.cafeyarv3.MainActivity
import com.example.cafeyarv3.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Created by abolfazl_dv on 25,April,2022
 */
class Fragment_CafeOnList : Fragment() {
    val cafeList = arrayListOf<Model_cafeList>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafeonlist , container , false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = (activity as MainActivity)
        val btnCafeOnMap = view.findViewById<CardView>(R.id.cardCafeOnListToMap)
        val cafeListRecycler = view.findViewById<RecyclerView>(R.id.cafeListRecyclerView)
        val btnFilter = view.findViewById<FloatingActionButton>(R.id.FAbCafeOnListFilter)
        cafeList.add(Model_cafeList(R.drawable.cafe2 , " کافه شماره 1" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        cafeList.add(Model_cafeList(R.drawable.cafe3 , " کافه شماره 2" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        cafeList.add(Model_cafeList(R.drawable.cafe4 , " کافه شماره 3" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        cafeList.add(Model_cafeList(R.drawable.cafe5 , " کافه شماره4" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        cafeList.add(Model_cafeList(R.drawable.cafe2 , " کافه شماره 5" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        cafeList.add(Model_cafeList(R.drawable.cafe3 , " کافه شماره 6" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        cafeList.add(Model_cafeList(R.drawable.cafe4 , " کافه شماره 7" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        val cafeListAdapter  = Adapter_cafeList(requireContext(), cafeList)
        cafeListRecycler.adapter = cafeListAdapter
        cafeListRecycler.layoutManager = LinearLayoutManager(requireContext())
        //
        btnCafeOnMap.setOnClickListener {
            mainActivity.replaceFragment(Fragment_CafeOnMap())
        }
        btnFilter.setOnClickListener {
            mainActivity.replaceFragment(Fragment_Search_Filter())
        }
    }
}