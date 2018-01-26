package com.efg.hangonaminute;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created 2018/01/26.
 */

public class PaintView extends View {

    private Path path= new Path();;
    private List<Path> paths = new ArrayList<Path>();

    private Paint paint = new Paint();
    private List<Paint> paints = new ArrayList<Paint>();




    public  PaintView(Context context){
        this(context,null);
    }

    public  PaintView(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int i = 0;
        for (Path path : paths) {
            canvas.drawPath(path, paints.get(i++));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                path = new Path();
                paths.add(path);

                paint = new Paint();
                paints.add(paint);
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeJoin(Paint.Join.ROUND);
                paint.setStrokeWidth(10);

                //random color
                Random random;
                random = new Random();
                int red,green,blue;
                red = random.nextInt(256);
                green = random.nextInt(256);
                blue = random.nextInt(256);
                paint.setColor(Color.rgb(red,green,blue));

                path.moveTo(x, y);
                invalidate();
                break;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                path.lineTo(x, y);
                invalidate();
                break;
        }
        return true;
    }

    public void clearAll(){
        for (Path path : paths) {
            path.reset();
        }

        for (Paint paint : paints) {
            paint.reset();
        }

        invalidate();
    }

    public void backOne(){

        Integer iCnt;

        iCnt = paths.size();
        paths.remove(iCnt-1);

        iCnt = paints.size();
        paints.remove(iCnt-1);

        invalidate();
    }



}
