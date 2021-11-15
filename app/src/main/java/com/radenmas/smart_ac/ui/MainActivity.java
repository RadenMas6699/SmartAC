package com.radenmas.smart_ac.ui;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.radenmas.smart_ac.R;
import com.radenmas.smart_ac.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private ImageView imgProfile;
    private LinearLayout acCristal, acLG, acMidea;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void myCodeHere() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        imgProfile = findViewById(R.id.imgProfile);
        acCristal = findViewById(R.id.ac_cristal);
        acLG = findViewById(R.id.ac_lg);
        acMidea = findViewById(R.id.ac_midea);

        imgProfile.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, InfoAppActivity.class));
        });

        acCristal.setOnClickListener(view -> {
            Intent cristal = new Intent(MainActivity.this, RemoteActivity.class);
            cristal.putExtra("type", "Cristal");
            startActivity(cristal);
        });

        acLG.setOnClickListener(view -> {
            Intent lg = new Intent(MainActivity.this, RemoteActivity.class);
            lg.putExtra("type", "LG");
            startActivity(lg);
        });

        acMidea.setOnClickListener(view -> {
            Intent midea = new Intent(MainActivity.this, RemoteActivity.class);
            midea.putExtra("type", "Midea");
            startActivity(midea);
        });

    }
}