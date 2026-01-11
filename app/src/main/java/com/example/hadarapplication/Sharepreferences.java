package com.example.hadarapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sharepreferences extends AppCompatActivity {
    SharedPreferences sp;
    Button btnSave;
    EditText etFname, etLname;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sharepreferences);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        etFname = findViewById(R.id.etFname);
        etLname =  findViewById(R.id.etLname);
        tvDisplay =  findViewById(R.id.tvDisplay);

        sp = getSharedPreferences("details", 0);

        readData();

        btnSave = findViewById(R.id.btnSubmit);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("fname", etFname.getText().toString());
                editor.putString("lname", etLname.getText().toString());
                editor.commit();
                readData();
            }
        });


    }

    private void readData() {
        String strname = sp.getString("fname", null);
        String strlname = sp.getString("lname", null);

        if (strlname != null && strname != null) {
            tvDisplay.setText("welcome" + strname + "" + strlname);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
