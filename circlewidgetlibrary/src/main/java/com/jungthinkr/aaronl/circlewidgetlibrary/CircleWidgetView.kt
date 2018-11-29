package com.jungthinkr.aaronl.circlewidgetlibrary

import android.content.Context
import android.graphics.Color
import android.support.annotation.AttrRes
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout

class CircleWidgetView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, @AttrRes defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), CircleWidget.CircleWidgetListener {
    interface CircleWidgetViewListener {
        fun onWidgetClick()
    }

    private var isWidgetFocused: Boolean = false
    var circleWidgetViewListener: CircleWidgetViewListener? = null

    init {
        val circleWidgetSize = context.resources.getDimension(R.dimen.circle_widget_size)
        val circleWidget = CircleWidget(this, context, attrs, 0)

        addView(circleWidget)
        circleWidget.layoutParams = LayoutParams(circleWidgetSize.toInt(), circleWidgetSize.toInt())
        circleWidget.setBackgroundColor(Color.RED)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {

            }

        }
        return super.onTouchEvent(event)
    }

    override fun onWidgetClick() {
        circleWidgetViewListener?.onWidgetClick()
    }

    override fun onWidgetActionDown() {
        isWidgetFocused = true
    }

    override fun onWidgetActionUp() {
        isWidgetFocused = false
    }
}
