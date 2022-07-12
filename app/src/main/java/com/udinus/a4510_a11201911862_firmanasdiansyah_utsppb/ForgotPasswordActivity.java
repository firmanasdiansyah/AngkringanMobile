package com.udinus.a4510_a11201911862_firmanasdiansyah_utsppb;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {


    EditText edittextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        edittextEmail = findViewById(R.id.edt_txt_email);
    }

    public void postSendRequest(View view) {

        if (TextUtils.isEmpty(edittextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "E-Mail Tidak Boleh Kosong !!!", Toast.LENGTH_LONG).show();
        }

        else
            if (!isValidEmail(edittextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "E-Mail Tidak Valid!!!", Toast.LENGTH_LONG).show();
        } else {

            Intent i = new Intent(ForgotPasswordActivity.this, ResetPasswordActivity.class);
            startActivity(i);
        }
    }

    public static boolean isValidEmail (CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }


}
