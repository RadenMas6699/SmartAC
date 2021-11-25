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
        imgProfile = findViewById(R.id.imgProfile);
        acCristal = findViewById(R.id.ac_cristal);
        acLG = findViewById(R.id.ac_lg);
        acMidea = findViewById(R.id.ac_midea);

        DatabaseReference dbAC = FirebaseDatabase.getInstance().getReference();

        imgProfile.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, InfoAppActivity.class));
        });

        acCristal.setOnClickListener(view -> {
            dbAC.child("ac_cristal").setValue(1);
            Intent cristal = new Intent(MainActivity.this, RemoteActivity.class);
            cristal.putExtra("type", "Cristal");
            startActivity(cristal);
        });

        acLG.setOnClickListener(view -> {
            dbAC.child("ac_LG").setValue(1);
            Intent lg = new Intent(MainActivity.this, RemoteActivity.class);
            lg.putExtra("type", "LG");
            startActivity(lg);
        });

        acMidea.setOnClickListener(view -> {
            dbAC.child("ac_midea").setValue(1);
            Intent midea = new Intent(MainActivity.this, RemoteActivity.class);
            midea.putExtra("type", "Midea");
            startActivity(midea);
        });

    }
}