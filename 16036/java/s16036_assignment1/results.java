package com.example.s16036_assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class results extends AppCompatActivity {
    TextView textView;
    public static final String KEY = "UNIQUEKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_results);

        textView = findViewById(R.id.resultValue);
        float bmi = getIntent().getFloatExtra("name",0);
        TextView textViewBMI = findViewById(R.id.resultValue);
        textViewBMI.setText("BMI ="+bmi+"kg/m2");

        Intent intent = getIntent();
        String data = intent.getStringExtra(KEY);
        textView.setText(data);
    }
    private void initializeBMICategories() {
        bmiCategories = new ArrayList<>();
        bmiCategories.add(new BMICategory("Severe Thinness", Double.MIN_VALUE, 16, Color.RED));
        bmiCategories.add(new BMICategory("Moderate Thinness", 16, 17, Color.parseColor("#FF4500"))); // OrangeRed
        bmiCategories.add(new BMICategory("Mild Thinness", 17, 18.5, Color.parseColor("#FFD700"))); // Gold
        bmiCategories.add(new BMICategory("Normal", 18.5, 25, Color.GREEN));
        bmiCategories.add(new BMICategory("Overweight", 25, 30, Color.YELLOW));
        bmiCategories.add(new BMICategory("Obese Class I", 30, 35, Color.parseColor("#FFA500"))); // Orange
        bmiCategories.add(new BMICategory("Obese Class II", 35, 40, Color.parseColor("#FF6347"))); // Tomato
        bmiCategories.add(new BMICategory("Obese Class III", 40, Double.MAX_VALUE, Color.RED));
    }

    private BMICategory getBMICategory(double bmi) {
        for (BMICategory category : bmiCategories) {
            if (bmi >= category.getMinBMI() && bmi < category.getMaxBMI()) {
                return category;
            }
        }
        return null;
    }

}