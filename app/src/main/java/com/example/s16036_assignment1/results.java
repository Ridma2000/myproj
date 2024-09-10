package com.example.s16036_assignment1;

import static android.content.Intent.getIntent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.s16036_assignment1.R;

public class results extends AppCompatActivity {

    private TextView textViewBMIResult, textViewBMICategory;

    @SuppressLint({"MissingInflatedId", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        textViewBMIResult = textViewBMIResult.findViewById(R.id.textViewBMIResult);
        textViewBMICategory = textViewBMIResult.findViewById(R.id.textViewBMICategory);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("BMI_VALUE")) {
            float bmi = intent.getFloatExtra("BMI_VALUE", 0);

            // Display BMI result
            textViewBMIResult.setText(String.format("BMI = %.1f", bmi,"kg/m2"));

            // Determine BMI category
            String category = getBMICategory(bmi);
            textViewBMICategory.setText(category);
            setBMICategoryColor(bmi);
        }
    }

    private void setContentView(int activityResults) {
    }

    private String getBMICategory(float bmi) {
        if (bmi < 16) {
            return "Severe Thinness";
        } else if (bmi >= 16 && bmi < 17) {
            return "Moderate Thinness";
        } else if (bmi >= 17 && bmi < 18.5) {
            return "Mild Thinness";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else if (bmi >= 30 && bmi < 35) {
            return "Obese Class I";
        } else if (bmi >= 35 && bmi < 40) {
            return "Obese Class II";
        } else {
            return "Obese Class III";
        }
    }

    private void setBMICategoryColor(float bmi) {
        int colorResId;
        if (bmi < 16) {
            colorResId = R.color.red;
        } else if (bmi >= 16 && bmi < 17) {
            colorResId = R.color.red;
        } else if (bmi >= 17 && bmi < 18.5) {
            colorResId = R.color.yellow;
        } else if (bmi >= 18.5 && bmi < 25) {
            colorResId = R.color.green;
        } else if (bmi >= 25 && bmi < 30) {
            colorResId = R.color.yellow;
        } else if (bmi >= 30 && bmi < 40) {
            colorResId = R.color.red;
        } else {
            colorResId = R.color.red;
        }
        textViewBMICategory.setTextColor(getResources().getColor(colorResId));
    }

    private javax.swing.JColorChooser getResources() {
        return null;
    }
}