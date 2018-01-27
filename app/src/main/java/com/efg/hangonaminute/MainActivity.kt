package com.efg.hangonaminute

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById(R.id.menu_button01).setOnClickListener { v -> menu_button01_Event(v) }

    }

    private fun menu_button01_Event(v: View) {
        //val intent = Intent(this, PaintActivity::class.java)
        val intent = Intent(this, PaintActivity::class.java)
        startActivity(intent)
    }


}
