package com.example.hadarapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentSecondActivity extends AppCompatActivity {
    TextView tvHello;
    TextView tvAge;
    TextView tvGender;
    EditText etBirthYear;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_intent);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            etBirthYear = findViewById(R.id.etBirthYear);
            return insets;
        });

        initVies();

        Intent intent = getIntent();
        if (intent == null) return;

        String name = intent.getStringExtra("EXTRA_NAME");
        int age = intent.getIntExtra("EXTRA_AGE",0);
        boolean isMale = intent.getBooleanExtra("EXTRA_Male",false);


        tvHello.setText(" שלום " + name);
        tvAge.setText(" גילך " + age);
        tvGender.setText(" המגדר שלך " + (isMale ? "זכר" : "נקבה"));

       // btnFinish.setOnCickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        IntentSecondActivity.this.finsh();
       //     }
      //  }
    }

    private void initVies() {
        tvHello = findViewById(R.id.tvHello);
        tvAge = findViewById(R.id.tvAge);
        tvGender = findViewById(R.id.tvGender);
        btnCalculate = findViewById(R.id.btnOk);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yearText = etBirthYear.getText().toString();
                if (!yearText.isEmpty()) {
                    int birthYear = Integer.parseInt(yearText);
                    int currentYear = 2026; // שנה נוכחית מוכנסת ידנית
                    int age = currentYear - birthYear;

                    Intent intent = new Intent();
                    intent.putExtra("age", age);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    etBirthYear.setError("אנא הכנס שנת לידה");
                }


            }
        });
    }


}