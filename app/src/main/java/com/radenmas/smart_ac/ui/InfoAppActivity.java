package com.radenmas.smart_ac.ui;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.TextView;

import com.radenmas.smart_ac.R;
import com.radenmas.smart_ac.base.BaseActivity;

public class InfoAppActivity extends BaseActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_info_app;
    }

    @Override
    protected void myCodeHere() {
        TextView tvVersionApp = findViewById(R.id.app_version);
        PackageManager manager = getApplication().getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(getApplicationContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        tvVersionApp.setText("Versi " + info.versionName);

    }

    public void Back(View view) {
        onBackPressed();
    }
}