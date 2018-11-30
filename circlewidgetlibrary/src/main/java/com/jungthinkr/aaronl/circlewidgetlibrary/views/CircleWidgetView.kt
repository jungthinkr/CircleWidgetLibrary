package com.jungthinkr.aaronl.circlewidgetlibrary.views

import android.content.Context
import android.graphics.Color
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import com.jungthinkr.aaronl.circlewidgetlibrary.R
import com.jungthinkr.aaronl.circlewidgetlibrary.tools.CircleWidgetOnTouchListener
import java.lang.ref.WeakReference

class CircleWidgetView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, @AttrRes defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr),
    CircleWidget.CircleWidgetListener {

    interface CircleWidgetViewListener {
        fun onWidgetClick()
    }

    private var circleWidgetViewListener: CircleWidgetViewListener? = null

    init {
        val circleWidgetSize = context.resources.getDimension(R.dimen.circle_widget_size)
        val circleWidget = CircleWidget(this, context, attrs, 0)

        addView(circleWidget)
        circleWidget.setOnTouchListener(CircleWidgetOnTouchListener(WeakReference(circleWidget)))
        circleWidget.layoutParams = LayoutParams(circleWidgetSize.toInt(), circleWidgetSize.toInt())
        circleWidget.setBackgroundColor(Color.RED)
    }

    override fun onWidgetClick() {
        circleWidgetViewListener?.onWidgetClick()
    }

//    override fun onWidgetTouchEvent(event: MotionEvent, widget: View) {
//        when (event.action) {
//            MotionEvent.ACTION_MOVE -> {
//                widget.translationY = event.y
//                widget.translationX = event.x
//                widget.layoutParams.
//            }
//            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
//               isWidgetFocused = true
//            }
//            MotionEvent.ACTION_POINTER_UP, MotionEvent.ACTION_UP -> {
//                isWidgetFocused = false
//            }
//        }
//    }

    fun setCircleWidgetViewListener(listener: CircleWidgetViewListener) {
        circleWidgetViewListener = listener
    }
}
