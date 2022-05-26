package com.example.cafeyarv3.Login_And_SignUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.cafeyarv3.MainActivity
import com.example.cafeyarv3.R
import com.google.android.material.textfield.TextInputEditText

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val textViewEnterAsGuest: TextView = findViewById(R.id.signUpTvEnterAsGuest)
        val buttonSignUp: Button = findViewById(R.id.signUpButtonsignUp)
        val editTextUserName: TextInputEditText = findViewById(R.id.signUpTietUserName)
        val editTextPassword: TextInputEditText = findViewById(R.id.signUpTietPassword)
        val editTextPhoneNumber: TextInputEditText = findViewById(R.id.signUpTietPhoneNumber)
        textViewEnterAsGuest.setOnClickListener {
            val intentEnterAsGuest = Intent(this, MainActivity::class.java)
            startActivity(intentEnterAsGuest)
            Toast.makeText(this, "شما به عنوان مهمان وارد شدید", Toast.LENGTH_SHORT).show()
            finish()
        }
        buttonSignUp.setOnClickListener {
            if (editTextUserName.text!!.trim().length < 5) {
                editTextUserName.error = "نام کاربری باید بیشتر از 5 حرف باشد"
            } else if (editTextPassword.text!!.trim().length < 6) {
                editTextPassword.error = "رمز عبور شما باید بیشتر از 6 حرف باشد"
            } else {
                val intentSignUp = Intent(this, MainActivity::class.java)
                startActivity(intentSignUp)
                Toast.makeText(this , "به اپلیکیشن ما خوش آمدید" , Toast.LENGTH_SHORT).show()
                finish()
            }


        }
    }
}