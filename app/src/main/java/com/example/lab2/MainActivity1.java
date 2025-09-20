package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity1 extends AppCompatActivity implements View.OnClickListener {

    private EditText etNum1, etNum2;
    private Button btnAdd, btnMinus, btnMultiply, btnDivide;
    private TextView tvResult;

    private final DecimalFormat df = new DecimalFormat("#.########");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main1);

        etNum1 = findViewById(R.id.editNum1);
        etNum2 = findViewById(R.id.editNum2);

        btnAdd      = findViewById(R.id.plus);
        btnMinus    = findViewById(R.id.minus);
        btnMultiply = findViewById(R.id.multiply);
        btnDivide   = findViewById(R.id.divide);

        tvResult = findViewById(R.id.txtResult);


        btnAdd.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        tvResult.setText("");

        Double a = getDoubleOrNull(etNum1);
        if (a == null) {
            tvResult.setText("Số thứ nất không hợp lệ");
            return;
        }

        Double b = getDoubleOrNull(etNum2);
        if (b == null) {
            tvResult.setText("Số thứ nất không hợp lệ");
            return;
        }

        if (v.getId() == R.id.divide && b == 0.0) {
            tvResult.setText("Không thể chia cho 0");
            return;
        }

        double res;
        int id = v.getId();
        if (id == R.id.plus) {
            res = a + b;
        } else if (id == R.id.minus) {
            res = a - b;
        } else if (id == R.id.multiply) {
            res = a * b;
        } else if (id == R.id.divide) {
            res = a / b;
        } else {
            return;
        }

        tvResult.setText(df.format(res));
    }

    private Double getDoubleOrNull(EditText et) {
        CharSequence cs = et.getText();
        if (cs == null) return null;
        String s = cs.toString().trim();
        if (s.isEmpty()) return null;
        try { return Double.valueOf(s); }
        catch (NumberFormatException ignore) { return null; }
    }
}