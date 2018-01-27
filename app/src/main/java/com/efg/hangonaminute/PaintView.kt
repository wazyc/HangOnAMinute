package com.efg.hangonaminute

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

import java.util.ArrayList
import java.util.Random

/**
 * Created 2018/01/26.
 */

class PaintView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private var path = Path()
    private val paths = ArrayList<Path>()

    private var paint = Paint()
    private val paints = ArrayList<Paint>()

    override fun onDraw(canvas: Canvas) {
        var i = 0
        for (path in paths) {
            canvas.drawPath(path, paints[i++])
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        val pointerId = event.getPointerId(event.actionIndex)

        //マルチタッチ　２つ目以降は処理しない
        if (pointerId < 1){

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {

                    path = Path()
                    paths.add(path)

                    paint = Paint()
                    paints.add(paint)
                    paint.isAntiAlias = true
                    paint.style = Paint.Style.STROKE
                    paint.strokeJoin = Paint.Join.ROUND
                    paint.strokeWidth = 10f

                    //random color
                    val random: Random
                    random = Random()
                    val red: Int
                    val green: Int
                    val blue: Int
                    red = random.nextInt(256)
                    green = random.nextInt(256)
                    blue = random.nextInt(256)
                    paint.color = Color.rgb(red, green, blue)

                    path.moveTo(x, y)
                    invalidate()
                }

                MotionEvent.ACTION_MOVE -> {
                    path.lineTo(x, y)
                    invalidate()
                }

                MotionEvent.ACTION_UP -> {
                    path.lineTo(x, y)
                    invalidate()
                }
            }
        }
        return true
    }

    fun clearAll() {
        for (path in paths) {
            path.reset()
        }

        for (paint in paints) {
            paint.reset()
        }

        invalidate()
    }

    fun backOne() {

        var iCnt: Int?

        iCnt = paths.size
        if (iCnt > 0 ){
            paths.removeAt(iCnt - 1)
        }

        iCnt = paints.size
        if (iCnt > 0 ){
            paints.removeAt(iCnt - 1)
        }

        invalidate()
    }


}
