package com.example.prohect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity   {
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
     //  setContentView( new MyGr(this));
       bt = (Button) findViewById(R.id.bt);
    }

    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.bt:
                i = new Intent(MainActivity.this, MyGr.class);
                startActivity(i);
                break;
        }
    }

    public void start(View view) {
        setContentView( new MyGr(this));
    }

    
}