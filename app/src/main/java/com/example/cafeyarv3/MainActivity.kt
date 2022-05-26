package com.example.cafeyarv3

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.cafeyarv2.Courses.Fragment_Courses
import com.example.cafeyarv2.Events.Fragment_Events
import com.example.cafeyarv2.FindCafe.Fragment_Home
import com.example.cafeyarv3.AddNewCafe.Fragment_NewCafe
import com.example.cafeyarv3.BugReport.Fragment_BugReport
import com.example.cafeyarv3.Favorites.Fragment_Favorites
import com.example.cafeyarv3.FindCafe.Fragment_CafeOnMap
import com.example.cafeyarv3.Friends.Fragment_Friends
import com.example.cafeyarv3.Profile.Fragment_Profile
import com.example.cafeyarv3.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class MainActivity : AppCompatActivity() {
    //
    lateinit var binding: ActivityMainBinding
    private var bottomSheetBehavior: BottomSheetBehavior<*>? = null
    private var isExpanded: Boolean = false

    //
    var btn_pullupImage: ConstraintLayout? = null
    var btn_userProfile: ConstraintLayout? = null
    var btn_friends: ConstraintLayout? = null
    var btn_favorites: ConstraintLayout? = null
    var btn_newCafe: ConstraintLayout? = null
    var btn_bugReport: Button? = null
    var btn_logOut: Button? = null
    var bottomNavigation: ChipNavigationBar? = null
    //
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this@MainActivity))
        setContentView(binding.root)
        // loading the default fragment here ...
        replaceFragment(Fragment_Home())
        // declaring my views
        myViews()
        val linearLayout: LinearLayout = findViewById(R.id.bottomSheet)
        bottomSheetBehavior = BottomSheetBehavior.from(linearLayout)
//        btn_pullupImage!!.setOnClickListener {
//            if (isExpanded) {
//                collapseBottomSheet()
//            } else {
//                expandBottomSheet()
//            }
//        }
        //

        // bottom navigation
        bottomNavigation!!.setItemSelected(R.id.BNavHome)
        bottomNavigation!!.setOnItemSelectedListener {
            when (it) {
                R.id.BNavCafe -> {
                    replaceFragment(Fragment_CafeOnMap())
                    collapseBottomSheet()
                }
                R.id.BNavCourse -> {
                    replaceFragment(Fragment_Courses())
                    collapseBottomSheet()
                }
                R.id.BNavEvent -> {
                    replaceFragment(Fragment_Events())
                    collapseBottomSheet()
                }
                R.id.BNavHome -> {
                    replaceFragment(Fragment_Home())
                    collapseBottomSheet()
                }
            }
            true
        }
        //bottom sheet pages direction
        btn_userProfile!!.setOnClickListener {
            replaceFragment(Fragment_Profile())
            collapseBottomSheet()
        }
        btn_friends!!.setOnClickListener {
            replaceFragment(Fragment_Friends())
            collapseBottomSheet()
        }
        btn_favorites!!.setOnClickListener {
            replaceFragment(Fragment_Favorites())
            collapseBottomSheet()
        }
        btn_newCafe!!.setOnClickListener {
            replaceFragment(Fragment_NewCafe())
            collapseBottomSheet()
        }
        btn_bugReport!!.setOnClickListener {
            replaceFragment(Fragment_BugReport())
            collapseBottomSheet()
        }
        btn_logOut!!.setOnClickListener {
            Toast.makeText(this, " you will log out", Toast.LENGTH_SHORT).show()
            collapseBottomSheet()
        }
    }

    private fun collapseBottomSheet() {
        (bottomSheetBehavior as BottomSheetBehavior<LinearLayout>).state =
            BottomSheetBehavior.STATE_COLLAPSED
        isExpanded = false
    }

    private fun expandBottomSheet() {
        (bottomSheetBehavior as BottomSheetBehavior<LinearLayout>).state =
            BottomSheetBehavior.STATE_EXPANDED
        isExpanded = true
    }

    private fun myViews() {

        btn_userProfile = findViewById(R.id.cons_profile)
        btn_friends = findViewById(R.id.cons_Friends)
        btn_favorites = findViewById(R.id.cons_Favorites)
        btn_newCafe = findViewById(R.id.cons_NewCafe)
        btn_bugReport = findViewById(R.id.BTNBugReport)
        btn_logOut = findViewById(R.id.BTNLogOut)
        bottomNavigation = findViewById(R.id.bottom_navigation)

    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment).commit()
    }

    // what happens when user click back button
    override fun onBackPressed() {
        if ((bottomSheetBehavior as BottomSheetBehavior<LinearLayout>).state == BottomSheetBehavior.STATE_EXPANDED) {
            collapseBottomSheet()
        } else {
            val builder = AlertDialog.Builder(this)
           builder.setTitle("خروج از اپلیکیشن")
            builder.setMessage("مطمئنی میخوای بری بیرون؟")
            builder.setPositiveButton("آره"){dialog , which ->
                finish()
            }
            builder.setNegativeButton("نه میخوام بمونم"){dialog , which ->

            }

            val createBuild = builder.create()
            createBuild.show()
        }
    }


}