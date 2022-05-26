package com.example.cafeyarv3.Events

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cafeyarv3.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import ru.embersoft.expandabletextview.ExpandableTextView

class EventDetailActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)
//        val expandableRules = findViewById<ExpandableTextView>(R.id.eventDetailExpandableTextView)
//        expandableRules.setOnStateChangeListener { isShrink ->
//            expandableRules.setText("این یه متن تست برای تکست ویو باز شونده اس که همینجوری مینویسیم یکم طولانی تر باشه بهتر معلوم باشه داریم چیکار میکنیم")
//            expandableRules.resetState(true)
//        }
    }
}