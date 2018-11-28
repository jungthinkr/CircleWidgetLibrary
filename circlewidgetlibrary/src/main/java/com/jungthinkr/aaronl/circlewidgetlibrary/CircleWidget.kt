package com.jungthinkr.aaronl.circlewidgetlibrary

import android.content.Context
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.FrameLayout

internal class CircleWidget @JvmOverloads constructor(
    circleWidgetListener: CircleWidgetListener,
    context: Context,
    attrs: AttributeSet? = null, @AttrRes defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    interface CircleWidgetListener {
        fun onWidgetClick()
    }

    init {
        setOnClickListener { circleWidgetListener.onWidgetClick() }
    }



    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_POINTER_UP -> {
            }
        }
        return super.onTouchEvent(event)
    }
}
