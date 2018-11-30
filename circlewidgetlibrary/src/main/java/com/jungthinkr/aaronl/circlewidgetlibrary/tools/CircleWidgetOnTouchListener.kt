package com.jungthinkr.aaronl.circlewidgetlibrary.tools

import android.view.MotionEvent
import android.view.View
import android.view.GestureDetector
import java.lang.IllegalArgumentException
import java.lang.ref.WeakReference

//TODO: set boundary for parent view
//TODO: set fling logic
class CircleWidgetOnTouchListener(val view: WeakReference<View>) : View.OnTouchListener {
    private val mGestureDetector: GestureDetector
    private val mGestureListener = object : GestureDetector.SimpleOnGestureListener() {
        private var mMotionDownX: Float = 0.toFloat()
        private var mMotionDownY: Float = 0.toFloat()

        override fun onDown(e: MotionEvent): Boolean {
            mMotionDownX = e.rawX - if (view.get() != null) view.get()!!.translationX else 0f
            mMotionDownY = e.rawY - if (view.get() != null) view.get()!!.translationY else 0f

            return true
        }

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            return super.onFling(e1, e2, velocityX, velocityY)
        }

        override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
            (view.get()?.parent as? View).let {
                it?.y + it?.width?: 0
            }
            view.get()?.translationX = e2.rawX - mMotionDownX
            view.get()?.translationY = e2.rawY - mMotionDownY
            return true
        }
    }

    init {
        if (view.get() == null) {
            throw IllegalArgumentException("Need to add a view into the constructor")
        }

        mGestureDetector = GestureDetector(view.get()!!.context, mGestureListener)
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return mGestureDetector.onTouchEvent(event)
    }
}
