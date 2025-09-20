package com.example.lab2;

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

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity2 extends AppCompatActivity {
    private EditText etMin, etMax;
    private TextView tvResult;
    private Button btnGen;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        etMin = findViewById(R.id.etMin);
        etMax = findViewById(R.id.etMax);
        tvResult = findViewById(R.id.tvResult);
        btnGen = findViewById(R.id.btnGen);

        btnGen.setOnClickListener(this::onGenerate);
    }

    private void onGenerate(View v) {
        tvResult.setText(""); // clear old message

        Integer min = parseIntOrNull(etMin);
        if (min == null) { tvResult.setText("Min không hợp lệ"); return; }

        Integer max = parseIntOrNull(etMax);
        if (max == null) { tvResult.setText("Max không hợp lệ"); return; }

        if (min > max) { tvResult.setText("Min phải ≤ Max"); return; }

        int result = min + random.nextInt(max - min + 1);
        tvResult.setText(String.valueOf(result));
    }

    private Integer parseIntOrNull(EditText et) {
        CharSequence cs = et.getText();
        if (cs == null) return null;
        String s = cs.toString().trim();
        if (s.isEmpty()) return null;
        try { return Integer.valueOf(s); } catch (NumberFormatException e) { return null; }
    }
}