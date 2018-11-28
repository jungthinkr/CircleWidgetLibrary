package com.jungthinkr.aaronl.circlewidgetlibrary

import android.content.Context
import android.support.annotation.AttrRes
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.FrameLayout

class CircleWidgetView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, @AttrRes defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), CircleWidget.CircleWidgetListener {
    init {
        val circleWidget = CircleWidget(this, context, attrs, 0)
        addView(circleWidget)
        
    }

    @Override
    override fun onWidgetClick() {
        TODO("not implemented")
    }
}
