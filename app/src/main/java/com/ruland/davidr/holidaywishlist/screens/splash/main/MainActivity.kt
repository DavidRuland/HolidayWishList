package com.ruland.davidr.holidaywishlist.screens.splash.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import com.ruland.davidr.holidaywishlist.R
import com.ruland.davidr.holidaywishlist.screens.splash.wish.WishActivity

class MainActivity : AppCompatActivity() {
    private var addB: FloatingActionButton? = null
    private var changeB: FloatingActionButton? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addB = findViewById(R.id.addL)
        changeB=findViewById(R.id.change)
        addB?.setOnClickListener {
            val intent = Intent(applicationContext, WishActivity::class.java)
            startActivity(intent)

        }
        changeB?.setOnClickListener {



        }
    }
}
