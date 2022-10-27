package com.pomct.pomct

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    lateinit var log_in: ImageView
    lateinit var forget: TextView
    lateinit var sign_up: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // how ar eyou

       log_in = findViewById(R.id.login_btn)
        log_in!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, Forget_Activity::class.java)
            startActivity(intent)
        })
        forget = findViewById(R.id.forget_btn)
        forget!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, Forget_Activity::class.java)
            startActivity(intent)
        })
        sign_up = findViewById(R.id.signup_btn)
        sign_up!!.setOnClickListener(View.OnClickListener {
            val Intent =Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(Intent)
        })
    }
}