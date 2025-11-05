package com.example.hadarapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Switch;
import android.widget.SeekBar;
public class MainActivity extends AppCompatActivity  {
    ImageView imageView;
    Switch switchImages;
    SeekBar seekBarLight;
    ImageView imageView2dog;
    float alpha = 1;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        start();

    }

    private void start() {
        imageView2dog.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.VISIBLE);
    }

    private void Views() {
        imageView = findViewById(R.id.imageView);
        button5 = findViewById(R.id.button5);
        imageView2dog = findViewById(R.id.imageView2dog);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void pluslight(View view){
        if (view.getId()==R.id.button3) {
            Toast.makeText(this, "darker", Toast.LENGTH_SHORT).show();
            if (alpha<1)
                alpha+=0.1f;
            imageView.setAlpha(alpha);
            imageView2dog.setAlpha(alpha);
        }
    }
    public void minuslight(View view){
        if (view.getId()==R.id.button2) {
            Toast.makeText(this, "lighter", Toast.LENGTH_SHORT).show();
            if (alpha>0)
                alpha-=0.1f;
            imageView.setAlpha(alpha);
            imageView2dog.setAlpha(alpha);
        }
    }
    public void imgChange2(View view){
        if (view.getId()==R.id.button4) {
            Toast.makeText(this, "changed", Toast.LENGTH_SHORT).show();
            if (imageView.getVisibility() == View.VISIBLE) {
                imageView.setVisibility(View.INVISIBLE);
                imageView2dog.setVisibility(View.VISIBLE);
            } else {
                imageView.setVisibility(View.VISIBLE);
                imageView2dog.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void initViews() {
        imageView = findViewById(R.id.imageView);
        button5 = findViewById(R.id.button5);
        imageView2dog = findViewById(R.id.imageView2dog);
        switchImages = findViewById(R.id.switchButton);
        seekBarLight = findViewById(R.id.seekBar);


        // מאזין לכפתור הקיים
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });

        // מאזין ל-Switch
        switchImages.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // כאשר הסוויץ' מופעל
                imageView.setVisibility(View.INVISIBLE);
                imageView2dog.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "changed", Toast.LENGTH_SHORT).show();
            } else {
                // כאשר הסוויץ' מכובה
                imageView.setVisibility(View.VISIBLE);
                imageView2dog.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "changed", Toast.LENGTH_SHORT).show();
            }
        });
        seekBarLight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float brightness  = i/100f;
                imageView.setAlpha(brightness);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "stop", Toast.LENGTH_SHORT).show();
            }
        });
    }


}