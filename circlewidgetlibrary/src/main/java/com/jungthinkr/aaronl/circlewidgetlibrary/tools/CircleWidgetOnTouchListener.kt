package com.jungthinkr.aaronl.circlewidgetlibrary.tools

import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.GestureDetector
import android.widget.Toast
import java.lang.IllegalArgumentException
import java.lang.ref.WeakReference

//TODO: set boundary for parent view
//TODO: set fling logic
class CircleWidgetOnTouchListener(view: View?) : View.OnTouchListener {
    private val mGestureDetector: GestureDetector
    init {
        if (view == null) {
            throw IllegalArgumentException("Need to add a view into the constructor")
        }

        mGestureDetector = GestureDetector(view.context, CircleWidgetSimpleOnGestureListener(view))
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return mGestureDetector.onTouchEvent(event)
    }
}
