package com.dmitryneladnov.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesString = inchesEditText.getText().toString();
                if (inchesString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Value is empty, input a value!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    double result = convertToMeters(inchesString);
                    displayResult(result);
                }
            }
        });
    }

    private void findViews() {
        inchesEditText = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.btn_calculate);
        resultTextView = findViewById(R.id.text_view_result);
    }

    private double convertToMeters(String inchesString) {
        int inches = Integer.parseInt(inchesString);
        return inches * 0.0254;
    }

    private void displayResult(double meters) {
        DecimalFormat f = new DecimalFormat("0.00");
        String formattedString = f.format(meters);
        String fullResultString;

        fullResultString = formattedString + " m";
        resultTextView.setText(fullResultString);
    }
}