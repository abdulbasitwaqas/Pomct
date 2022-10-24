package com.pomct.pomct

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var handler: Handler? = null
    var runnable: Runnable? = null
    var img: ImageView? = null
    @SuppressLint("Range")
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = Handler()
        handler!!.postDelayed({
            val dsp = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(dsp)
            finish()
        }, 4000)
    }
}