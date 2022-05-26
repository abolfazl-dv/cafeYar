package com.example.cafeyarv3.Login_And_SignUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.cafeyarv3.MainActivity
import com.example.cafeyarv3.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val edittextUsername : TextInputEditText = findViewById(R.id.loginTietUserName)
        val edittextPassword : TextInputEditText = findViewById(R.id.loginTietPassWord)
        val buttonLogin : Button= findViewById(R.id.loginButtonLogin)
        val textviewCreateAccount : TextView = findViewById(R.id.loginTvCreateAccount)
        val textViewEnterAsGuest : TextView = findViewById(R.id.loginTvEnterAsGuest)
        buttonLogin.setOnClickListener {
            if (edittextUsername.text!!.equals("") || edittextUsername.text!!.length < 5) {
                edittextUsername.error = "نام کاربری نباید کمتر 5 حرف باشد"
            }
            if (edittextPassword.text!!.equals("") || edittextPassword.text!!.length < 6){
                edittextPassword.error = "طول رمز عبور نباید از 6 رقم کمتر باشد"
            }else{
                val intentToMainActivity = Intent(this, MainActivity::class.java)
                startActivity(intentToMainActivity)
                finish()
            }

        }
        textviewCreateAccount.setOnClickListener {
            val intentToSignUpActivity  = Intent(this , SignUpActivity::class.java)
            startActivity(intentToSignUpActivity)
            finish()
        }
        textViewEnterAsGuest.setOnClickListener {
            val intentAsGuest = Intent(this , MainActivity::class.java)
            startActivity(intentAsGuest)
            finish()
        }

    }

}