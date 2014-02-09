package com.CommonLayout;

import com.CommonLayout.R;

import android.app.Activity;
import android.os.Bundle;

public class CommonLayout extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.absolutelayout);
    }
}