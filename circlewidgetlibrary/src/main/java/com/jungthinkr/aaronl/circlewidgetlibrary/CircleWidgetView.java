package com.jungthinkr.aaronl.circlewidgetlibrary;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class CircleWidgetView extends FrameLayout {

    public CircleWidgetView(@NonNull Context context) {
        this(context, null);
    }

    public CircleWidgetView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
    }

    public CircleWidgetView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initProperties();
    }

    void initProperties() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_POINTER_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }
}
