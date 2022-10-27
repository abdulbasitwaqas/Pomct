package com.pomct.pomct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class Forget_Activity : AppCompatActivity(){
    lateinit var otpcode: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget)

        otpcode = findViewById(R.id.reset_btn)
        otpcode!!.setOnClickListener(View.OnClickListener {
            val Intent = Intent(this@Forget_Activity,OtpActivity::class.java)
            startActivity(Intent)
        })
    }
}