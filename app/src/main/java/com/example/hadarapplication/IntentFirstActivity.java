package com.example.hadarapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentFirstActivity extends AppCompatActivity {

    TextView tvNowAge;
    Button editAge;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        int age = data.getIntExtra("age", 0);
                        tvNowAge.setText("גיל: " + age);
                    }
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first_intent);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
                EditText etName = IntentFirstActivity.this.findViewById(R.id.etName);
                EditText etAge = IntentFirstActivity.this.findViewById(R.id.etAge);
                CheckBox cbMale = IntentFirstActivity.this.findViewById(R.id.cbMale);
                Button btnSend = IntentFirstActivity.this.findViewById(R.id.btnSend);
                tvNowAge = IntentFirstActivity.this.findViewById(R.id.tvNowAge);
        editAge = findViewById(R.id.tbnowAge);

                btnSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = etName.getText().toString();
                        String ageStr = etAge.getText().toString();
                        int age = ageStr.isEmpty() ? 0 : Integer.parseInt(ageStr);
                        boolean isMale = cbMale.isChecked();

                        Intent intent = new Intent(IntentFirstActivity.this, IntentSecondActivity.class);
                        intent.putExtra("EXTRA_NAME", name);
                        intent.putExtra("EXTRA_AGE", age);
                        intent.putExtra("EXTRA_Male", isMale);
                        startActivity(intent);
                    }
                });

                editAge.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(IntentFirstActivity.this, IntentSecondActivity.class);
                        launcher.launch(intent);
                    }
                });
            }
        }



