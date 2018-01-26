package com.efg.hangonaminute;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.menu_button01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_button01_Event(v);
            }


        });

    }

    private void menu_button01_Event(View v){
        Intent intent = new Intent(this,PaintActivity.class);
        startActivity(intent);
    }





}
