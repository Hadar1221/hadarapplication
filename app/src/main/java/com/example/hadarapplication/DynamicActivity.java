package com.example.hadarapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dynamic);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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