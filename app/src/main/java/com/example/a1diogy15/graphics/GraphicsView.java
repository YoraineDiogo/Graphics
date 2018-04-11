package com.example.a1diogy15.graphics;

/**
 * Created by 1diogy15 on 11/04/2018.
 */
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.content.Context;


public class GraphicsView extends View implements View.OnTouchListener //this implementation makes the view capable of listening to touch events
{
    Paint p;
    Bitmap image;
    int counter = 0;
    float curX, curY; //x and y psoition of the touch event


    public GraphicsView (Context ctx)
    {
        super(ctx);

        p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(24);

        image =   BitmapFactory.decodeResource(ctx.getResources(), R.drawable.hero);



        this.setOnTouchListener(this);//this means that we are adding a touch listener to the view
        //the view is both the view being touched and the event handler
    }

    public void onDraw (Canvas canvas)
    {
        //HERE IS WHERE WE WRITE OUR DRAWING INSTRUCTIONS
        p.setStyle(Paint.Style.FILL);
        canvas.drawRect(10, 10, 110, 110, p);
        canvas.drawText("Hello Graphics World!", 0, 200, p);

        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(3);
        canvas.drawRect(10,400,410,800,p);

        canvas.drawBitmap(image , curX, curY, null);

        counter ++;
        canvas.drawText("Counter is now" + counter, 0, 300, p);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        //event.getX() and event.getY - position of the touch event
      //  Log.d("graphics", "onTouch: " + event.getX() + " " + event.getY());

        curX = event.getX();//the touch position
        curY =event.getY(); //the touch pos

        postInvalidate(); //causes canvas to redraw or causes onDraw to run
        return true;
    }

    //drawing a hero and a vilain helps with the async task, progress - gestures
}
