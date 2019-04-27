package com.jungthinkr.aaronl.circlewidgetlibrary.tools

import android.content.res.Resources
import android.support.animation.DynamicAnimation
import android.support.animation.FlingAnimation
import android.util.DisplayMetrics
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewPropertyAnimator

class CircleWidgetSimpleOnGestureListener(private val view: View) : GestureDetector.SimpleOnGestureListener() {
    private var mMotionDownX: Float = 0.toFloat()
    private var mMotionDownY: Float = 0.toFloat()
    private val totalWidth: Float
        get() = Resources.getSystem().displayMetrics.widthPixels.toFloat()
    private val totalHeight: Float
        get() = (view.parent as View).height.toFloat()


    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        if (velocityX < 0.5f && velocityY < 0.5) {
            return false
        }
        FlingAnimation(view, DynamicAnimation.TRANSLATION_X).apply {
            setStartVelocity(velocityX)
            setMinValue(0f)
            setMaxValue(totalWidth-view.width)
            friction = 0.2f
            minimumVisibleChange = 0.5f
            start()
        }

        FlingAnimation(view, DynamicAnimation.TRANSLATION_Y).apply {
            setStartVelocity(velocityY)
            setMinValue(0f)
            setMaxValue(totalHeight-view.height)
            minimumVisibleChange = 0.5f
            friction = 0.2f
            start()
        }
        return super.onFling(e1, e2, velocityX, velocityY)
    }

    override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        val transX = e2.rawX - mMotionDownX
        val transY = e2.rawY - mMotionDownY
        translateView(transX, transY, view)
        return true
    }


    private fun translateView(transX: Float, transY: Float, view: View) {
        val parentAsView = view.parent as? View

        view.translationX = when {
            transX < 0 -> 0f
            transX + view.width >= parentAsView?.width ?: 0 -> (parentAsView?.width?.toFloat() ?: 0f) - view.width.toFloat()
            else -> transX
        }

        view.translationY = when {
            transY < 0 -> 0f
            transY + view.height >= parentAsView?.height ?: 0 -> (parentAsView?.height?.toFloat() ?: 0f) - view.height.toFloat()
            else -> transY
        }
    }
}

