package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class SignInActivity extends AppCompatActivity {
    EditText etUsernameIn, etPasswordIn;
    Button btnSignIn;
    TextView tvGoSignUp;

    public static HashMap<String, String> accounts = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        etUsernameIn = findViewById(R.id.etUsernameIn);
        etPasswordIn = findViewById(R.id.etPasswordIn);
        btnSignIn    = findViewById(R.id.btnSignIn);
        tvGoSignUp   = findViewById(R.id.tvGoSignUp);

        tvGoSignUp.setOnClickListener(v ->
                startActivity(new Intent(this, SignUpActivity.class)));

        btnSignIn.setOnClickListener(v -> {
            String u = etUsernameIn.getText().toString().trim();
            String p = etPasswordIn.getText().toString();

            if (u.isEmpty() || p.isEmpty()) {
                Toast.makeText(this, "Không được để trống", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!accounts.containsKey(u)) {
                Toast.makeText(this, "Chưa có tài khoản, hãy đăng ký", Toast.LENGTH_SHORT).show();
            } else if (accounts.get(u).equals(p)) {
                Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Sai username hoặc password", Toast.LENGTH_SHORT).show();
            }
        });
    }

}