package com.radenmas.smart_ac.ui;

import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.radenmas.smart_ac.R;
import com.radenmas.smart_ac.base.BaseActivity;

public class RemoteAct extends BaseActivity {
    private TextView tvAcName, tvTemp, tvSwing;
    private ImageView imgPower, imgSpeed, imgSwing, minTemp, addTemp;
    private TextView btnSwing, btnSpeed;
    private DatabaseReference dbReff;
    private RelativeLayout rlTemp, rlSwing, rlSpeed;
    int swing = 0;
    int speed = 0;
    int power = 0;
    int temp = 24;

    @Override
    protected int getLayoutResource() {
        return R.layout.act_remote;
    }

    @Override
    protected void myCodeHere() {
        dbReff = FirebaseDatabase.getInstance().getReference();

        String acName = getIntent().getExtras().getString("type");

        tvAcName = findViewById(R.id.tvAcName);
        rlTemp = findViewById(R.id.rlTemp);
        rlSwing = findViewById(R.id.rlSwing);
        rlSpeed = findViewById(R.id.rlSpeed);
        tvTemp = findViewById(R.id.tvTemp);
        tvSwing = findViewById(R.id.tvSwing);
        imgPower = findViewById(R.id.imgPower);
        imgSpeed = findViewById(R.id.imgSpeed);
        imgSwing = findViewById(R.id.imgSwing);
        minTemp = findViewById(R.id.minTemp);
        addTemp = findViewById(R.id.addTemp);
        btnSwing = findViewById(R.id.btnSwing);
        btnSpeed = findViewById(R.id.btnSpeed);

        tvAcName.setText(acName);
        onClick();
    }

    private void onClick() {
        imgPower.setOnClickListener(v -> {
            power = power + 1;
            switch (power) {
                case 1:
                    Off();
                    break;
                case 2:
                    On();
                    break;
            }
        });
    }

    public void On() {
        dbReff.child("Power").setValue(2);
        new Handler().postDelayed(() -> dbReff.child("Power").setValue(0),1000);

        power = 0;
        tvTemp.setText("" + temp);
        rlTemp.setVisibility(View.VISIBLE);
        rlSwing.setVisibility(View.VISIBLE);
        rlSpeed.setVisibility(View.VISIBLE);
        imgPower.setColorFilter(Color.argb(255, 0, 200, 83));
        btnSwing.setClickable(true);
        btnSpeed.setClickable(true);
        addTemp.setClickable(true);
        minTemp.setClickable(true);

        btnSpeed.setOnClickListener(view -> {
            speed = speed + 1;
            switch (speed) {
                case 1:
                    dbReff.child("Speed").setValue(1);
                    new Handler().postDelayed(() -> dbReff.child("Speed").setValue(0),1000);
                    imgSpeed.setImageResource(R.drawable.ic_speed_1);
                    break;

                case 2:
                    dbReff.child("Speed").setValue(1);
                    new Handler().postDelayed(() -> dbReff.child("Speed").setValue(0),1000);
                    imgSpeed.setImageResource(R.drawable.ic_speed_2);
                    break;

                case 3:
                    dbReff.child("Speed").setValue(1);
                    new Handler().postDelayed(() -> dbReff.child("Speed").setValue(0),1000);
                    imgSpeed.setImageResource(R.drawable.ic_speed_3);
                    speed = 0;
                    break;
            }
        });

        btnSwing.setOnClickListener(view -> {
            swing = swing + 1;
            switch (swing) {
                case 1:
                    dbReff.child("Swing").setValue(1);
                    new Handler().postDelayed(() -> dbReff.child("Swing").setValue(0),1000);
                    imgSwing.setImageResource(R.drawable.ic_swing_down);
                    tvSwing.setText(getResources().getString(R.string.arrow_bottom));
                    break;

                case 2:
                    dbReff.child("Swing").setValue(1);
                    new Handler().postDelayed(() -> dbReff.child("Swing").setValue(0),1000);
                    imgSwing.setImageResource(R.drawable.ic_swing_up);
                    tvSwing.setText(getResources().getString(R.string.arrow_top));
                    break;

                case 3:
                    dbReff.child("Swing").setValue(1);
                    new Handler().postDelayed(() -> dbReff.child("Swing").setValue(0),1000);
                    imgSwing.setImageResource(R.drawable.ic_swing_center);
                    tvSwing.setText(getResources().getString(R.string.arrow_center));
                    swing = 0;
                    break;
            }
        });

        minTemp.setOnClickListener(view -> {
            if (temp <= 16) {
                minTemp.setClickable(false);
                addTemp.setClickable(true);
            } else {
                temp = temp - 1;
                tvTemp.setText("" + temp);
                minTemp.setClickable(true);
                addTemp.setClickable(true);
            }
            dbReff.child("Suhu").setValue(temp);
            new Handler().postDelayed(() -> dbReff.child("Suhu").setValue(0),1000);
        });

        addTemp.setOnClickListener(view -> {
            if (temp >= 30) {
                addTemp.setClickable(false);
                minTemp.setClickable(true);
            } else {
                temp = temp + 1;
                tvTemp.setText("" + temp);
                minTemp.setClickable(true);
                addTemp.setClickable(true);
            }
            dbReff.child("Suhu").setValue(temp);
            new Handler().postDelayed(() -> dbReff.child("Suhu").setValue(0),1000);
        });
    }

    public void Off() {
        dbReff.child("Power").setValue(1);
        new Handler().postDelayed(() -> dbReff.child("Power").setValue(0),1000);
        rlTemp.setVisibility(View.INVISIBLE);
        rlSwing.setVisibility(View.INVISIBLE);
        rlSpeed.setVisibility(View.INVISIBLE);
        imgPower.setColorFilter(Color.argb(255, 222, 222, 222));
        btnSwing.setClickable(false);
        btnSpeed.setClickable(false);
        addTemp.setClickable(false);
        minTemp.setClickable(false);
    }

    public void Back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        dbReff.child("ac_samsung").setValue(0);
        dbReff.child("ac_LG").setValue(0);
        dbReff.child("ac_midea").setValue(0);
    }
}