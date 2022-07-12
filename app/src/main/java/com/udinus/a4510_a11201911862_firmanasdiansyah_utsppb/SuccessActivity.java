package com.udinus.a4510_a11201911862_firmanasdiansyah_utsppb;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

    }
    public void clickBack(View view) {
        Intent i = new Intent(SuccessActivity.this, WelcomeActivity.class);
        startActivity(i);
    }
    public void clicMenu(View view) {
        Intent i = new Intent(SuccessActivity.this, MenuActivity.class);
        startActivity(i);
    }
    public void clickOrder(View view) {
        Intent i = new Intent(SuccessActivity.this, PembelianActivity.class);
        startActivity(i);
    }
    public void clickTransaksi(View view) {
        Toast.makeText(view.getContext()," TRANSAKSI Masih Dalam Pengembangan",Toast.LENGTH_LONG).show();
    }
    public void clickAbout(View view) {
        Intent i = new Intent(SuccessActivity.this, TentangKamiActivity.class);
        startActivity(i);
    }
    public void clickSetting(View view) {
        Toast.makeText(view.getContext()," SETTING Masih Dalam Pengembangan",Toast.LENGTH_LONG).show();
    }
}
