package com.radenmas.smart_ac.base;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    protected abstract int getLayoutResource();

    protected abstract void myCodeHere();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(getLayoutResource());

        myCodeHere();
    }

    protected void toastS(String message) {
        Toast.makeText(getApplicationContext(), "" + message, Toast.LENGTH_SHORT).show();
    }

    protected void toastL(String message) {
        Toast.makeText(getApplicationContext(), "" + message, Toast.LENGTH_LONG).show();
    }
}
