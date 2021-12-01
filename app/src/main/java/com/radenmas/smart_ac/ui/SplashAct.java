package com.radenmas.smart_ac.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.widget.TextView;

import com.radenmas.smart_ac.R;
import com.radenmas.smart_ac.base.BaseActivity;

public class SplashAct extends BaseActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.act_splash;
    }

    @Override
    protected void myCodeHere() {
        TextView tvVersionApp = findViewById(R.id.tvAppVersion);
        PackageManager manager = getApplication().getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(getApplicationContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        tvVersionApp.setText("Versi " + info.versionName);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashAct.this, MainAct.class));
            finish();
        }, 1500);
    }
}