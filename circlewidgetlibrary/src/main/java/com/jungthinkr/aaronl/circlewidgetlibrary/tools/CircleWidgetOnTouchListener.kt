package com.jungthinkr.aaronl.circlewidgetlibrary.tools

import android.util.Log
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
            val view = if (view.get() != null) view.get() else null
            if (view != null) {
                val transX = e2.rawX - mMotionDownX
                val transY = e2.rawY - mMotionDownY
                val parentAsView = view.parent as? View

                when {
                    transX <= 0 ->
                        view.translationX = 0f
                    transX + view.width >= parentAsView?.width ?: 0 ->
                        view.translationX = (parentAsView?.width?.toFloat() ?: 0f) - view.width.toFloat()
                    else ->
                        view.translationX = e2.rawX - mMotionDownX
                }

                when {
                    transY <= 0 ->
                        view.translationY = 0f
                    transY + view.height >= parentAsView?.height ?: 0 ->
                        view.translationY = (parentAsView?.height?.toFloat() ?: 0f) - view.height.toFloat()
                    else ->
                        view.translationY = e2.rawY - mMotionDownY
                }
            }
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
        when(event.action) {
            MotionEvent.ACTION_OUTSIDE ->
                Log.e("outside", event.action.toString())
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP, MotionEvent.ACTION_CANCEL ->
                Log.e("uptouchevent", event.action.toString())
        }
        return mGestureDetector.onTouchEvent(event)
    }
}
