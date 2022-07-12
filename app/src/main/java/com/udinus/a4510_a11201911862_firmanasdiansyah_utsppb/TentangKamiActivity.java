package com.udinus.a4510_a11201911862_firmanasdiansyah_utsppb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TentangKamiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_kami);
    }

    public void mapss(View view) {
        Intent i = new Intent(TentangKamiActivity.this, MapsActivity.class);
        startActivity(i);
    }
}