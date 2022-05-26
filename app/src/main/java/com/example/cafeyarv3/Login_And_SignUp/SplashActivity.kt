package com.example.cafeyarv3.Login_And_SignUp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.cafeyarv3.MainActivity
import com.example.cafeyarv3.R

class SplashActivity : AppCompatActivity() {

    companion object {
        const val SHARED_PREFS = "sharedPrefs"
        const val IS_FIRST_TIME = "isFirstTime"
    }

    private var isFirstTime: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val splashLogo: ImageView = findViewById(R.id.splashLogo)
        //
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        isFirstTime = sharedPreferences.getBoolean(IS_FIRST_TIME, true)
        editor.apply()


        splashLogo.postDelayed(Runnable {
            if (isFirstTime) {
                val intentToIntro = Intent(this, IntroActivity::class.java)
                editor.putBoolean(IS_FIRST_TIME, false).apply()
                startActivity(intentToIntro)
                finish()
            } else {
                val intentToMain = Intent(this, MainActivity::class.java)
                startActivity(intentToMain)
                finish()
            }
        }, 3000)
    }
}