package com.pomct.pomct

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    lateinit var log_in: Button
    lateinit var forget: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        log_in = findViewById<Button>(R.id.login_btn)
        log_in!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, Forget_Activity::class.java)
            startActivity(intent)
        })
        forget = findViewById<Button>(R.id.forget_btn)
        forget!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, Forget_Activity::class.java)
            startActivity(intent)
        })
    }
}