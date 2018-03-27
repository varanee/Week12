package com.micky.it.week12;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyButton myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.myBtn1);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}

class MyButton extends View {

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)



    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Paint paint = new Paint();

        paint.setColor(Color.RED);
        canvas.drawRect(40,20,90,80,paint);

        paint.setColor(Color.GREEN);
        //canvas.drawCircle(400,500,200,paint);
        canvas.drawArc(30,800,400,1200,0,180,true,paint);

        paint.setColor(Color.RED);
        //canvas.drawCircle(40,500,200,paint);

        canvas.drawArc(50,820,380,1180,0,180,true,paint);


        paint.setColor(Color.BLACK);
        //canvas.drawOval(150,1200,320,1280,paint);


        int whichColor = (int)(Math.random()* 4);
        if(whichColor == 0) paint.setColor(Color.RED);
        else if(whichColor == 1) paint.setColor(Color.GREEN);
        else if(whichColor == 2) paint.setColor(Color.BLUE);
        else paint.setColor(Color.YELLOW);
        canvas.drawRect(40,20,90,80,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_BUTTON_PRESS){
            float x = event.getX();
            float y = event.getY();

            if (x >= 40 && x <= 90 && y >= 20 && y <= 80){
                invalidate();
            }
        }
        return true;
    }
}
