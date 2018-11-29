package com.jungthinkr.aaronl.circlewidgetlibrary

import android.content.Context
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout

internal class CircleWidget @JvmOverloads constructor(
    private val circleWidgetListener: CircleWidgetListener,
    context: Context,
    attrs: AttributeSet? = null, @AttrRes defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    interface CircleWidgetListener {
        fun onWidgetClick()
        fun onWidgetActionDown()
        fun onWidgetActionUp()
    }

    init {
        setOnClickListener { circleWidgetListener.onWidgetClick() }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                circleWidgetListener.onWidgetActionDown()
            }
            MotionEvent.ACTION_POINTER_UP, MotionEvent.ACTION_UP -> {
                circleWidgetListener.onWidgetActionUp()
            }
        }
        return super.onTouchEvent(event)
    }
}
