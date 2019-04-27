package com.jungthinkr.aaronl.circlewidgetlibrary.views

import android.content.Context
import android.graphics.Color
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.widget.FrameLayout
import com.jungthinkr.aaronl.circlewidgetlibrary.R

class CircleBackgroundView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr),
    CircleView.CircleWidgetListener {

    interface CircleWidgetViewListener {
        fun onWidgetClick()
    }

    private var circleWidgetViewListener: CircleWidgetViewListener? = null

    init {
        // init circleview
        val circleWidgetSize = context.resources.getDimension(R.dimen.circle_widget_size)
        val circleView = CircleView(this, context, attrs, 0)
        addView(circleView)
        circleView.layoutParams = FrameLayout.LayoutParams(circleWidgetSize.toInt(), circleWidgetSize.toInt())
        circleView.setBackgroundColor(Color.RED)
    }

    override fun onWidgetClick() {
        circleWidgetViewListener?.onWidgetClick()
    }

    fun setCircleWidgqtViewListener(listener: CircleWidgetViewListener) {
        circleWidgetViewListener = listener
    }
}
