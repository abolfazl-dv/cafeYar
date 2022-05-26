package com.example.cafeyarv3.Friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.Friends.Adapter.Adapter_Friends
import com.example.cafeyarv3.Friends.Model.Model_Friends
import com.example.cafeyarv3.R

/**
 * Created by abolfazl_dv on 02,April,2022
 */
class Fragment_Friends: Fragment() {
    var friendsList = arrayListOf<Model_Friends>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_friends , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val friendsRecyclerView = view.findViewById<RecyclerView>(R.id.friendsRecycler)
        friendsList.add(Model_Friends("دوست شماره 1" , R.drawable.user , "AD865215"))
        friendsList.add(Model_Friends("دوست شماره 2" , R.drawable.user , "AD832481"))
        friendsList.add(Model_Friends("دوست شماره 3" , R.drawable.user , "AD321901"))
        friendsList.add(Model_Friends("دوست شماره 4" , R.drawable.user , "AD845666"))
        friendsList.add(Model_Friends("دوست شماره 5" , R.drawable.user , "AD234785"))
        friendsList.add(Model_Friends("دوست شماره 6" , R.drawable.user , "AD800034"))
        friendsList.add(Model_Friends("دوست شماره 7" , R.drawable.user , "AD143234"))
        friendsList.add(Model_Friends("دوست شماره 8" , R.drawable.user , "AD454678"))
        friendsList.add(Model_Friends("دوست شماره 9" , R.drawable.user , "AD578999"))
        friendsList.add(Model_Friends("دوست شماره 10" , R.drawable.user , "AD555555"))
        friendsRecyclerView.adapter = Adapter_Friends(requireContext(), friendsList)
        friendsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}