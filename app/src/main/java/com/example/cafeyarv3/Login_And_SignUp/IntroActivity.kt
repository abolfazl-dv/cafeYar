package com.example.cafeyarv3.Login_And_SignUp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cafeyarv3.R
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment

class IntroActivity : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addSlide(
            AppIntroFragment.createInstance(
                title = "به اپلیکیشن ما خوش اومدین",
                description = "این یه اپلیکیشن برای پیدا کردن کافه، \n اطلاع رسانی ایونت و آموزش باریستاییه",
                titleColorRes = R.color.teal_200,
                descriptionColorRes = R.color.black,
                backgroundColorRes = R.color.back1
            )
        )

        addSlide(
            AppIntroFragment.createInstance(
                title = R.string.intro2Title.toString(),
                description = R.string.intro2Desc.toString(),
                titleColorRes = R.color.purple_200,
                descriptionColorRes = R.color.purple_700,
                backgroundColorRes = R.color.back3
            )
        )

        addSlide(
            AppIntroFragment.createInstance(
                title = R.string.intro3Title.toString(),
                description = R.string.intro3Desc.toString(),
                titleColorRes = R.color.black,
                descriptionColorRes = R.color.teal_700,
                backgroundColorRes = R.color.back2
            )
        )
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        Toast.makeText(this, " you tapped skip", Toast.LENGTH_SHORT).show()
        val intentToLogin = Intent(this, LoginActivity::class.java)
        startActivity(intentToLogin)
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        Toast.makeText(this, " you tapped done", Toast.LENGTH_SHORT).show()
        val intentToLogin = Intent(this, LoginActivity::class.java)
        startActivity(intentToLogin)
        finish()
    }
}