package com.swellner.wvnfcflicker;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by SWellner on 11.02.2016.
 */
public class MyWebview extends WebView {
    public MyWebview(Context context) {
        super(context);
    }

    public MyWebview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyWebview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public MyWebview(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
