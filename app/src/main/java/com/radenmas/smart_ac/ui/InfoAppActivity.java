package com.radenmas.smart_ac.ui;

import android.view.View;

import com.radenmas.smart_ac.R;
import com.radenmas.smart_ac.base.BaseActivity;

public class InfoAppActivity extends BaseActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_info_app;
    }

    @Override
    protected void myCodeHere() {

    }

    public void Back(View view) {
        onBackPressed();
    }
}