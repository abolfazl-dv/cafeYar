package com.example.cafeyarv3.CafeOnList

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.FindCafe.Adapter.Adapter_cafeList
import com.example.cafeyarv3.FindCafe.Model.Model_cafeList
import com.example.cafeyarv3.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class CafeOnListActivity : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }
val cafeList = arrayListOf<Model_cafeList>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cafe_on_list)
        val cafeListRecycler = findViewById<RecyclerView>(R.id.cafeListRecyclerView)
        cafeList.add(Model_cafeList(R.drawable.cafe2 , " کافه شماره 1" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        cafeList.add(Model_cafeList(R.drawable.cafe3 , " کافه شماره 2" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        cafeList.add(Model_cafeList(R.drawable.cafe4 , " کافه شماره 3" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        cafeList.add(Model_cafeList(R.drawable.cafe5 , " کافه شماره4" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        cafeList.add(Model_cafeList(R.drawable.cafe2 , " کافه شماره 5" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        cafeList.add(Model_cafeList(R.drawable.cafe3 , " کافه شماره 6" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        cafeList.add(Model_cafeList(R.drawable.cafe4 , " کافه شماره 7" ,  "آدرس کافه شماره1  آدرس کافه شماره 1 آدرس کافه شماره 1"))
        val cafeListAdapter  = Adapter_cafeList(this, cafeList)
        cafeListRecycler.adapter = cafeListAdapter
        cafeListRecycler.layoutManager = LinearLayoutManager(this)
    }
}