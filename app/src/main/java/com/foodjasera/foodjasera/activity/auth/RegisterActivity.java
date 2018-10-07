package com.foodjasera.foodjasera.activity.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.activity.MainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_register)
    public void buttonRegister() {
        Toast.makeText(this, "Registrasi Berhasil !", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @OnClick(R.id.btn_to_login)
    public void toLogin(){
        startActivity(new Intent(this, LoginActivity.class));
        finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
