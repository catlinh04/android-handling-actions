package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {
    EditText etUsernameUp, etPasswordUp, etConfirmPass;
    Button btnSignUp;
    TextView tvGoSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        etUsernameUp = findViewById(R.id.etUsernameUp);
        etPasswordUp = findViewById(R.id.etPasswordUp);
        etConfirmPass= findViewById(R.id.etConfirmPass);
        btnSignUp    = findViewById(R.id.btnSignUp);
        tvGoSignIn   = findViewById(R.id.tvGoSignIn);

        tvGoSignIn.setOnClickListener(v ->
                startActivity(new Intent(this, SignInActivity.class)));

        btnSignUp.setOnClickListener(v -> {
            String u = etUsernameUp.getText().toString().trim();
            String p = etPasswordUp.getText().toString();
            String c = etConfirmPass.getText().toString();

            if (u.isEmpty() || p.isEmpty() || c.isEmpty()) {
                Toast.makeText(this, "Không được để trống", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!p.equals(c)) {
                Toast.makeText(this, "Password và Confirm không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            SignInActivity.accounts.put(u, p);
            Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}