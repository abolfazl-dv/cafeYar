package com.example.cafeyarv3.CafeDetail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeyarv3.CafeDetail.Adapter.AdapterCafeDetailSlider
import com.example.cafeyarv3.CafeOnList.CafeOnListActivity
import com.example.cafeyarv3.Comment.Adapter.Adapter_CommentList
import com.example.cafeyarv3.Comment.Model.Model_CommentList
import com.example.cafeyarv3.GlideImageLoadingService
import com.example.cafeyarv3.R
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import ss.com.bannerslider.Slider

class CafeDetailActivity : AppCompatActivity() {

    private var commentList = arrayListOf<Model_CommentList>()

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cafe_detail)
        val commentRecycler  = findViewById<RecyclerView>(R.id.cafeDetailCommentRecycler)
        val slider = findViewById<Slider>(R.id.banner_slider)
        Slider.init(GlideImageLoadingService(this))
        slider.setAdapter(AdapterCafeDetailSlider())

        val btnHome = findViewById<CardView>(R.id.cafeDetailButtonHome)
        btnHome.setOnClickListener {
            val intent = Intent(this, CafeOnListActivity::class.java)
            startActivity(intent)
            finish()
        }

        commentList.add(Model_CommentList(R.drawable.user, "کاربر شماره 1", "8" , "تجربه خیلی خوبی بود.", "4.5", "روز پیش"))
        commentList.add(Model_CommentList(R.drawable.user, "کاربر شماره 1", "8" , "اگه چند تا بورد گیم هم به کافه تون اضافه کنین خیلی خوشحال میشیم.", "4.5", "روز پیش"))
        commentList.add(Model_CommentList(R.drawable.user, "کاربر شماره 1", "8" , "نحوه برخورد پرسنل عالی بود ولی یکم نظافت رو رعایت نکردن که اگه سری بعدی بیشتر حواسشون باشه خوشحال میشیم.", "4.5", "روز پیش"))
        commentList.add(Model_CommentList(R.drawable.user, "کاربر شماره 1", "8" , "اصلا خوب نبود.", "4.5", "روز پیش"))
        commentList.add(Model_CommentList(R.drawable.user, "کاربر شماره 1", "8" , "تنوع توی منوی کافه خیلی کم و انتخاب زیادی نداشتیم، کاش یکم آیتم های منو رو بیشتر میکردید.", "4.5", "روز پیش"))
        commentList.add(Model_CommentList(R.drawable.user, "کاربر شماره 1", "8" , "فضا خیلی پر از دود بود و اصلا هواکش یا تهویه ای در کار نبود.", "4.5", "روز پیش"))
        commentList.add(Model_CommentList(R.drawable.user, "کاربر شماره 1", "8" , "چقد خوب که فضای مناسب کودک داشتین تو کافه تون ، اینجوری با خیال راحت میتونستم با دوستام وقت بگذرونم.", "4.5", "روز پیش"))
        commentList.add(Model_CommentList(R.drawable.user, "کاربر شماره 1", "8" , "قیمت ها الکی بالا بود و به نظرم ارزش بیشتر از یبار رفتن نداشت.", "4.5", "روز پیش"))
        commentRecycler.adapter = Adapter_CommentList(this, commentList)
        commentRecycler.layoutManager = LinearLayoutManager(this)
    }
}