package com.example.s16036_assignment1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    public static final String KEY = "UNIQUEKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //editText = findViewById(R.id.editText);
        EditText editTextAge = findViewById(R.id.age);
        EditText editTextWeight = findViewById(R.id.weight);
        EditText editTextHeight = findViewById(R.id.height);
        Button button = findViewById(R.id.btnSubmit);
        TextView textView = findViewById(R.id.resultValue);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ageStr = editTextAge.getText().toString();
                String heightStr = editTextHeight.getText().toString();
                String weightStr = editTextWeight.getText().toString();
                String nameStr = editText.getText().toString();
                if (ageStr.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }
                int age = Integer.parseInt(editTextAge.getText().toString());
                if (age < 18) {
                    Toast.makeText(MainActivity.this, "Age must be 18 or above to use this app.", Toast.LENGTH_SHORT).show();
                    return;
                }
                float height = Float.parseFloat(String.valueOf(editTextHeight.getText())) / 100;
                float weight = Float.parseFloat(String.valueOf(editTextWeight.getText()));
                float bmi = weight / (height * height);
                textView.setText(String.valueOf(bmi));

                String data = editText.getText().toString();
                Intent intent = new Intent(getBaseContext(),results.class);
                intent.putExtra(KEY,data);
                startActivity(intent);

            }
            public void Calculate(View view){
                String data = editText.getText().toString();
                Intent intent = new Intent(getBaseContext(),results.class);
                intent.putExtra(KEY,data);
                startActivity(intent);
            }

            public void onBackPressed() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you want to exit ?");
                builder.setTitle("Alert !");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    finish();
                });
                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    dialog.cancel();
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

        });
    }
}