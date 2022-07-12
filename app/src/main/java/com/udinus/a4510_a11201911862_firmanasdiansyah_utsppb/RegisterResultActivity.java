package com.udinus.a4510_a11201911862_firmanasdiansyah_utsppb;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_result);

    }

    public void clickBack(View view) {
        Intent i = new Intent(RegisterResultActivity.this, LoginActivity.class);
        startActivity(i);
    }
}