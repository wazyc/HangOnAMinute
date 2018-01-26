package com.efg.hangonaminute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PaintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        //けすボタンリスナー
        findViewById(R.id.paint_button01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paint_button01_Event01(v);
            }
        });

        //もどるボタンリスナー
        findViewById(R.id.paint_button02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paint_button02_Event02(v);
            }
        });


    }

    //けすボタン
    private void paint_button01_Event01(View v){
        PaintView paintview = (PaintView) findViewById(R.id.paintview);
        paintview.clearAll();
        //finish();
    }
    //もどるボタン
    private void paint_button02_Event02(View v){
        PaintView paintview = (PaintView) findViewById(R.id.paintview);
        paintview.backOne();
        //finish();
    }


}
