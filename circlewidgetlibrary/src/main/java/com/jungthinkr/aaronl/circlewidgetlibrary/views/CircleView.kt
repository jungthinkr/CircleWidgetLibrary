package com.jungthinkr.aaronl.circlewidgetlibrary.views

import android.content.Context
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import com.jungthinkr.aaronl.circlewidgetlibrary.tools.CircleWidgetOnTouchListener

//Circle width
internal class CircleView @JvmOverloads constructor(
    private val circleWidgetListener: CircleWidgetListener,
    context: Context,
    attrs: AttributeSet? = null, @AttrRes defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {


    interface CircleWidgetListener {
        fun onWidgetClick()
    }

    init {
        setOnClickListener { circleWidgetListener.onWidgetClick() }
        setOnTouchListener(CircleWidgetOnTouchListener(this))
    }
}
