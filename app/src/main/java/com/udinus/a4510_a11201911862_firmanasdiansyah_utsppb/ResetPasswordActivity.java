package com.udinus.a4510_a11201911862_firmanasdiansyah_utsppb;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordActivity extends AppCompatActivity {


    EditText editTextresetCode;
    EditText editTextnewPassword;
    EditText editTextconfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);


        editTextresetCode= findViewById(R.id.edt_txt_code);
        editTextnewPassword = findViewById(R.id.edt_new_password);
        editTextconfirmPassword = findViewById(R.id.edt_confirm_password);
    }

    public void postChangePassword(View view) {

   String confirmpass = editTextconfirmPassword.getText().toString();
        String newpass = editTextnewPassword.getText().toString();


        if (TextUtils.isEmpty(editTextresetCode.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextnewPassword.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextconfirmPassword.getText().toString().trim())
        ) {
            Toast.makeText(view.getContext(), "Semua Kolom Masih kosong," +
                    "Harap isi terlebih dahulu...", Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(editTextresetCode.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextnewPassword.getText().toString().trim()))
         {
            Toast.makeText(view.getContext(), "Kolom Reset Code dan New Password  Masih Kosong!...," +
                    "Harap isi terlebih dahulu...", Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(editTextresetCode.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextconfirmPassword.getText().toString().trim())
        ) {
            Toast.makeText(view.getContext(), "Kolom Reset Code dan Confirm Password Masih Kosong!...," +
                    "Harap isi terlebih dahulu...", Toast.LENGTH_LONG).show();
        }

        else if (TextUtils.isEmpty(editTextnewPassword.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextconfirmPassword.getText().toString().trim())
                &&
                (newpass.equals(confirmpass))
        ) {
            Toast.makeText(view.getContext(), "Kolom New Password dan Confirm Password Masih Kosong!...," +
                    "Harap isi terlebih dahulu...", Toast.LENGTH_LONG).show();
        }

        else if (TextUtils.isEmpty(editTextresetCode.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Kolom Reset Code Masih Kosong!...," +
                    "Harap isi terlebih dahulu...", Toast.LENGTH_LONG).show();
        }

        else if (TextUtils.isEmpty(editTextnewPassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Kolom New Password Masih Kosong!...," +
                    "Harap isi terlebih dahulu...", Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(editTextconfirmPassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), " Kolom Confirm Password Masih Kosong!...," +
                    "Harap isi terlebih dahulu...", Toast.LENGTH_LONG).show();
        }
        // Cek inputan new dan confirm
        else if (!newpass.equals(confirmpass)){
            Toast.makeText(view.getContext(), "Confirm Password Tidak Sesuai", Toast.LENGTH_LONG).show();
        }



        else {
            Intent i = new Intent(ResetPasswordActivity.this, RegisterResultActivity.class);
            startActivity(i);



        } }}



