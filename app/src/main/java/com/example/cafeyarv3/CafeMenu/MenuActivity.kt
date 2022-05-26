package com.example.cafeyarv3.CafeMenu

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.cafeyarv3.MainActivity
import com.example.cafeyarv3.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val filterAutoCompleteCafeType =
            findViewById<AutoCompleteTextView>(R.id.Filter_Actv_CafeType)
        val items = listOf(
            "کافه",
            "قهوه فروشی",
            "کافه باغ",
            "کافه رستوران",
            "کافه گیم", "کافه کتاب", "کافه سیار")
        val cafeTypeAdapter = ArrayAdapter(this, R.layout.listitem_dropdown_cafetype, items)
        filterAutoCompleteCafeType.setAdapter(cafeTypeAdapter)

    }
}