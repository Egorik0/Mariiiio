package com.example.prohect;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;



public class MyGr extends View {

    public static int height=1024, width=800;
    float x=100,y = 10, dy=0;
    float ground = 400;
    float gravity = 1;
    float heroWidth, heroHeight;
    float enemyWidth, enemyHeight;
    // картинка героя
    Bitmap enemy,bitmap,background;
    MyTimer timer;

    float xE=1600,yE = 460, dxE=-10;
    float xB=1600,yB = 460, dxB=-10;

    public MyGr(Context context) {
        super(context);
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        height = metrics.heightPixels;
        width = metrics.widthPixels;
         heroWidth = width/10;
         heroHeight = height/7;
         enemyWidth = width/20;
         enemyHeight = height/10;
        Resources resources = getContext().getResources();
        background = BitmapFactory.decodeResource( resources,R.drawable.background2);
        background = Bitmap.createScaledBitmap(background,width, height,true);
        bitmap = BitmapFactory.decodeResource( resources,R.drawable.mario1333);
        bitmap = Bitmap.createScaledBitmap(bitmap,(int)heroWidth, (int) heroHeight,true);
        enemy = BitmapFactory.decodeResource( resources,R.drawable.zombie);
        enemy = Bitmap.createScaledBitmap(enemy,(int)enemyWidth, (int)enemyHeight,true);
         timer = new MyTimer(1000000, 20);
        timer.start();

    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(background,0,0,p);
        canvas.drawBitmap(bitmap,x,y,p);
        canvas.drawBitmap(enemy,xE,yE,p);
        move();
       moveEnemy();
        collision();
        int score=0;
        score++;
        p.setTextSize(32);
        p.setColor(Color.GREEN);
        canvas.drawText(score+"",200,200,p);

    }
//движение героя
    public void move() {
        dy += gravity;
        y += dy;
        if (y > ground) y = ground;
    }
        //движение врага
    public void moveEnemy(){
       xE+=dxE;
       if(xE<-100) xE=width;
    }
   public void  collision(){
       //Log.d("tagg", "collision: "+x+" "+y+" "+(heroWidth));

       Rect r1 = new Rect((int)x,(int)y,(int)(x+heroWidth),(int)(y+heroHeight));
       Rect r2 = new  Rect((int)xE,(int)yE,(int)(xE+enemyWidth),(int)(yE+enemyHeight));
       Log.d("tagg", ""+r1.intersect(r2));
       if(r1.intersect(r2)) {
           timer.cancel();
         //  Log.d("tagg", "collision: ");
       }

   }
    public boolean onTouchEvent(MotionEvent event) {
       if(y==ground) dy = -30;
        return true;
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
