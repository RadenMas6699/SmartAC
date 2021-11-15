package com.radenmas.smart_ac.ui;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.radenmas.smart_ac.R;
import com.radenmas.smart_ac.base.BaseActivity;

public class RemoteActivity extends BaseActivity {
    TextView tvAcName, tvTemp, tvSwing;
    ImageView imgPower, imgSpeed, imgSwing, minTemp, addTemp;
    TextView btnSwing, btnSpeed;

    RelativeLayout rlTemp, rlSwing, rlSpeed;
    int swing = 0;
    int speed = 0;
    int power = 0;
    int temp = 24;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_remote;
    }

    @Override
    protected void myCodeHere() {
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
                    tvTemp.setText("" + temp);
                    rlTemp.setVisibility(View.VISIBLE);
                    rlSwing.setVisibility(View.VISIBLE);
                    rlSpeed.setVisibility(View.VISIBLE);
                    imgPower.setColorFilter(Color.argb(255, 0, 200, 83));
                    btnSwing.setClickable(true);
                    btnSpeed.setClickable(true);
                    addTemp.setClickable(true);
                    addTemp.setClickable(true);

                    btnSpeed.setOnClickListener(view -> {
                        speed = speed + 1;
                        switch (speed) {
                            case 1:
                                imgSpeed.setImageResource(R.drawable.ic_speed_1);
                                break;

                            case 2:
                                imgSpeed.setImageResource(R.drawable.ic_speed_2);
                                break;

                            case 3:
                                imgSpeed.setImageResource(R.drawable.ic_speed_3);
                                speed = 0;
                                break;
                        }
                    });

                    btnSwing.setOnClickListener(view -> {
                        swing = swing + 1;
                        switch (swing) {
                            case 1:
                                imgSwing.setImageResource(R.drawable.ic_swing_down);
                                tvSwing.setText("Arah Bawah");
                                break;

                            case 2:
                                imgSwing.setImageResource(R.drawable.ic_swing_up);
                                tvSwing.setText("Arah Atas");
                                break;

                            case 3:
                                imgSwing.setImageResource(R.drawable.ic_swing_center);
                                tvSwing.setText("Arah Tengah");
                                swing = 0;
                                break;
                        }
                    });

                    minTemp.setOnClickListener(view -> {
                        temp = temp - 1;
                        tvTemp.setText("" + temp);
                        if (temp == 16) {
                            minTemp.setClickable(false);
                            addTemp.setClickable(true);
                        } else {
                            minTemp.setClickable(true);
                            addTemp.setClickable(true);
                        }
                    });

                    addTemp.setOnClickListener(view -> {
                        temp = temp + 1;
                        tvTemp.setText("" + temp);
                        if (temp == 30) {
                            addTemp.setClickable(false);
                            minTemp.setClickable(true);
                        } else {
                            minTemp.setClickable(true);
                            addTemp.setClickable(true);
                        }
                    });

                    break;
                case 2:
                    rlTemp.setVisibility(View.INVISIBLE);
                    rlSwing.setVisibility(View.INVISIBLE);
                    rlSpeed.setVisibility(View.INVISIBLE);
                    imgPower.setColorFilter(Color.argb(255, 222, 222, 222));
                    power = 0;
                    btnSwing.setClickable(false);
                    btnSpeed.setClickable(false);
                    addTemp.setClickable(false);
                    addTemp.setClickable(false);
                    break;
            }
        });
    }

    public void Back(View view) {
        onBackPressed();
    }
}