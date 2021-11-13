package com.radenmas.smart_ac.ui;

import android.content.Intent;
import android.widget.LinearLayout;

import com.radenmas.smart_ac.R;
import com.radenmas.smart_ac.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private LinearLayout acCristal, acLG, acMidea;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void myCodeHere() {
        acCristal = findViewById(R.id.ac_cristal);
        acLG = findViewById(R.id.ac_lg);
        acMidea = findViewById(R.id.ac_midea);

        acCristal.setOnClickListener(v -> {
            Intent cristal = new Intent(MainActivity.this, RemoteActivity.class);
            cristal.putExtra("type", "cristal");
            startActivity(cristal);
        });
        acLG.setOnClickListener(v -> {
            Intent lg = new Intent(MainActivity.this, RemoteActivity.class);
            lg.putExtra("type", "lg");
            startActivity(lg);
        });
        acMidea.setOnClickListener(v -> {
            Intent midea = new Intent(MainActivity.this, RemoteActivity.class);
            midea.putExtra("type", "midea");
            startActivity(midea);
        });

    }
}