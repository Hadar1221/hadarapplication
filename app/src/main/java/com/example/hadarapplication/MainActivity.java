package com.example.hadarapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Switch;
import android.widget.SeekBar;
public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Switch switchImages;
    SeekBar seekBarLight;
    ImageView imageView2dog;
    float alpha = 1;
    Button button5;


    TextView tv;


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

        tv = (TextView) findViewById(R.id.tv);

        registerForContextMenu(tv);



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

    public void pluslight(View view) {
        if (view.getId() == R.id.button3) {
            Toast.makeText(this, "darker", Toast.LENGTH_SHORT).show();
            if (alpha < 1)
                alpha += 0.1f;
            imageView.setAlpha(alpha);
            imageView2dog.setAlpha(alpha);
        }
    }

    public void minuslight(View view) {
        if (view.getId() == R.id.button2) {
            Toast.makeText(this, "lighter", Toast.LENGTH_SHORT).show();
            if (alpha > 0)
                alpha -= 0.1f;
            imageView.setAlpha(alpha);
            imageView2dog.setAlpha(alpha);
        }
    }

    public void imgChange2(View view) {
        if (view.getId() == R.id.button4) {
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
                float brightness = i / 100f;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        if (item.getItemId() == R.id.firstline) {
            Toast.makeText(this, "You selected first line",
                    Toast.LENGTH_LONG).show();
            return true;

        } else if (item.getItemId() == R.id.secondline) {
            Toast.makeText(this, "You selected second line",
                    Toast.LENGTH_LONG).show();
            return true;
        }

        return false;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        int id = item.getItemId();

        if (R.id.action_mainpage == id) {
            Intent intent = new Intent(this, MainActivity.class);
            Toast.makeText(this, "You selected main page", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        } else if (R.id.action_dynamic == id) {
            Intent intent = new Intent(this, DynamicActivity.class);
            Toast.makeText(this, "You selected DynamicActivity", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        } else if (R.id.action_sharepreferences == id) {
            Intent intent = new Intent(this, Sharepreferences.class);
            Toast.makeText(this, "You selected Sharepreferences", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }
        else if (R.id.action_dialog == id) {
            Intent intent = new Intent(this, DialogActivity.class);
            Toast.makeText(this, "You selected DialogActivity", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }

        return true;
    }

}