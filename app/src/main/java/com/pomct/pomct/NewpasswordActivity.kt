package com.pomct.pomct

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class NewpasswordActivity : AppCompatActivity() {
    lateinit var confirm_btn: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newpassword)

        confirm_btn = findViewById(R.id.config_btn)
        confirm_btn!!.setOnClickListener(View.OnClickListener {
            val Intent = Intent(this@NewpasswordActivity,LoginActivity::class.java)
            startActivity(Intent)
        })
    }
}