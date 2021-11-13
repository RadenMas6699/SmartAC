package com.radenmas.smart_ac.ui;

import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.radenmas.smart_ac.R;
import com.radenmas.smart_ac.base.BaseActivity;

public class RemoteActivity extends BaseActivity {
    TextView tvTemp, tvMode;
    ImageView imgSpeed, imgMode, minTemp, addTemp;
    TextView btnSwing, btnMode;
    int swing = 0;
    int mode = 0;
    int temp = 24;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_remote;
    }

    @Override
    protected void myCodeHere() {

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.monitor));
        }


        tvTemp = findViewById(R.id.tvTemp);
        tvMode = findViewById(R.id.tvMode);
        imgSpeed = findViewById(R.id.imgSpeed);
        imgMode = findViewById(R.id.imgMode);
        minTemp = findViewById(R.id.minTemp);
        addTemp = findViewById(R.id.addTemp);
        btnSwing = findViewById(R.id.btnSwing);
        btnMode = findViewById(R.id.btnMode);

        onClick();

        if (temp >= 17 && temp <= 30) {

        }
    }

    private void onClick() {
        btnSwing.setOnClickListener(v -> {
            swing = swing + 1;
            switch (swing) {
                case 1:
                    imgSpeed.setImageResource(R.drawable.ic_speed_1);
                    break;

                case 2:
                    imgSpeed.setImageResource(R.drawable.ic_speed_2);
                    break;

                case 3:
                    imgSpeed.setImageResource(R.drawable.ic_speed_3);
                    swing = 0;
                    break;
            }
        });

        btnMode.setOnClickListener(v -> {
            mode = mode + 1;
            switch (mode) {
                case 1:
                    imgMode.setImageResource(R.drawable.ic_speed_1);
                    tvMode.setText("Arah Atas");
                    break;

                case 2:
                    imgMode.setImageResource(R.drawable.ic_speed_2);
                    tvMode.setText("Arah Tengah");
                    break;

                case 3:
                    imgMode.setImageResource(R.drawable.ic_speed_3);
                    tvMode.setText("Arah Bawah");
                    mode = 0;
                    break;

            }
        });

        minTemp.setOnClickListener(v -> {
            temp = temp - 1;
            tvTemp.setText("" + temp);
            if (temp <= 16) {
                minTemp.setClickable(false);
                addTemp.setClickable(true);
            }
        });

        addTemp.setOnClickListener(v -> {
            temp = temp + 1;
            tvTemp.setText("" + temp);
            if (temp >= 30) {
                addTemp.setClickable(false);
                minTemp.setClickable(true);
            }
        });
    }
}