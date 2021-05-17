package com.example.prohect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyGr extends View implements View.OnTouchListener{
    float x = 100, y = 100;

    public MyGr(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        canvas.drawCircle(x, y, 199, p);
        canvas.drawBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.mario),100,100,p);
    }

    public boolean onTouchEvent(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            x = event.getX();
            y = event.getY();
            Log.d("tagg", "onTouch: " + x);
            invalidate();
                return false;

        }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        Log.d("tagg", "onTouch22222: " + x);
        return false;
    }
}


