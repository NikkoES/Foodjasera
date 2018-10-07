package com.foodjasera.foodjasera.activity.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.activity.MainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void buttonLogin() {
        Toast.makeText(this, "Login Berhasil !", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @OnClick(R.id.btn_to_register)
    public void toRegister() {
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    @OnClick(R.id.btn_to_forgot_password)
    public void toForgotPassword() {
        startActivity(new Intent(getApplicationContext(), ForgotPasswordActivity.class));
        finish();
    }
}
