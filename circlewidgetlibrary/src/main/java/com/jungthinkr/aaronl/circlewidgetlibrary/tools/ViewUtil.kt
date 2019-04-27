package com.jungthinkr.aaronl.circlewidgetlibrary.tools

import android.content.res.Resources
import android.util.TypedValue

class ViewUtil {
    companion object {
        fun pxToDp(px: Float): Float {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, Resources.getSystem().displayMetrics)
        }
    }
}
