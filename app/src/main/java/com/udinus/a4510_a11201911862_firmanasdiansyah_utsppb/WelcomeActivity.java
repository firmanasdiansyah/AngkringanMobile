package com.udinus.a4510_a11201911862_firmanasdiansyah_utsppb;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }


    public void clickLogin(View view) {
        Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
        startActivity(i);
    }

    public void clickDaftar(View view) {
        Intent i = new Intent(WelcomeActivity.this, RegisterActivity.class);
        startActivity(i);
    }
}
