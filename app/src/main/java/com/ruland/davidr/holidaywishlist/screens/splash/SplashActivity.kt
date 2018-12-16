package com.ruland.davidr.holidaywishlist.screens.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ruland.davidr.holidaywishlist.R
import com.ruland.davidr.holidaywishlist.screens.splash.main.MainActivity

class SplashActivity : AppCompatActivity() {


    private var mDHandler: Handler? = null
    private val delay: Long = 3000 //3 seconds

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mDHandler = Handler()
        mDHandler!!.postDelayed(mRunnable, delay)

    }

    public override fun onDestroy() {

        if (mDHandler != null) {

            mDHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }

}