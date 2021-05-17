package com.example.prohect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity   {
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(new DrawView(this));

       setContentView( new MyGr(this));
     //   bt = (Button) findViewById(R.id.bt);
     //   bt.setOnClickListener(this);
    }

   /* public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.bt:
                i = new Intent(MainActivity.this, ActivityTwo1.class);
                startActivity(i);
                break;
        }
    } */

}