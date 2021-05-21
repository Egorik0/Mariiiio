package com.example.prohect;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyGr extends View implements View.OnTouchListener{
    public static int height, width;
    float y = 10, dy=0;
    float ground = 300;
    float gravity = 2;
    Bitmap bitmap;


    public MyGr(Context context) {
        super(context);
        Resources resources = getContext().getResources();
        bitmap = BitmapFactory.decodeResource( resources,R.drawable.hero0);
        MyTimer timer = new MyTimer(1000000, 50);
        timer.start();
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(metrics);

        height = metrics.heightPixels;
        width = metrics.widthPixels;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(bitmap,100,y,p);
        move();

    }
    public void move(){
        dy+=gravity;
        y+=dy;
        if(y>ground) y = ground;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        dy = -30;
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public class MyTimer extends CountDownTimer{

        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {

            invalidate();
        }

        @Override
        public void onFinish() {

        }
    }
}
