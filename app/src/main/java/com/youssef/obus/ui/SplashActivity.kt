package com.youssef.obus.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.youssef.obus.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Initializing the Handler
        var mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))

        }, 5000)

        Runnable {
        }

    }
}
