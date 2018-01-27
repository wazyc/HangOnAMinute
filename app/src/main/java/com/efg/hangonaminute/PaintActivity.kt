package com.efg.hangonaminute

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class PaintActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint)

        //けすボタンリスナー
        findViewById(R.id.paint_button01).setOnClickListener { v -> paint_button01_Event01(v) }

        //もどるボタンリスナー
        findViewById(R.id.paint_button02).setOnClickListener { v -> paint_button02_Event02(v) }


    }

    //けすボタン
    private fun paint_button01_Event01(v: View) {
        val paintview = findViewById(R.id.paintview) as PaintView
        paintview.clearAll()
        //finish();
    }

    //もどるボタン
    private fun paint_button02_Event02(v: View) {
        val paintview = findViewById(R.id.paintview) as PaintView
        paintview.backOne()
        //finish();
    }


}
