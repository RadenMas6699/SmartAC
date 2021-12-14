package com.radenmas.smart_ac.ui;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.radenmas.smart_ac.R;
import com.radenmas.smart_ac.base.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainAct extends BaseActivity {
    private TextView tvTime, tvCalender;
    private ImageView imgProfile;
    private LinearLayout acCristal, acLG;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    int back = 0;

    @Override
    protected int getLayoutResource() {
        return R.layout.act_main;
    }

    @Override
    protected void myCodeHere() {
        tvTime = findViewById(R.id.tvTime);
        tvCalender = findViewById(R.id.tvCalender);
        imgProfile = findViewById(R.id.imgProfile);
        acCristal = findViewById(R.id.ac_cristal);
        acLG = findViewById(R.id.ac_lg);

        DatabaseReference dbAC = FirebaseDatabase.getInstance().getReference();

        imgProfile.setOnClickListener(view -> {
            startActivity(new Intent(MainAct.this, InfoAppAct.class));
        });

        Date dt = new Date();
        int hours = dt.getHours();
        if (hours >= 1 && hours <= 11) {
            tvTime.setText("Selamat Pagi");
        } else if (hours > 11 && hours <= 15) {
            tvTime.setText("Selamat Siang");
        } else if (hours > 15 && hours <= 18) {
            tvTime.setText("Selamat Sore");
        } else if (hours > 18 && hours <= 24) {
            tvTime.setText("Selamat Malam");
        }

        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd MMM yyyy");
        date = dateFormat.format(calendar.getTime());
        tvCalender.setText(date);

        acCristal.setOnClickListener(view -> {
            dbAC.child("ac_cristal").setValue(1);
            Intent cristal = new Intent(MainAct.this, RemoteAct.class);
            cristal.putExtra("type", getResources().getString(R.string.ac_samsung));
            startActivity(cristal);
        });

        acLG.setOnClickListener(view -> {
            dbAC.child("ac_LG").setValue(1);
            Intent lg = new Intent(MainAct.this, RemoteAct.class);
            lg.putExtra("type", getResources().getString(R.string.ac_lg));
            startActivity(lg);
        });
    }

    @Override
    public void onBackPressed() {
        back++;
        if (back == 1) {
            toastS("Tekan sekali lagi untuk keluar.");
        } else {
            super.onBackPressed();
        }

    }
}