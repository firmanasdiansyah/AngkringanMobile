package com.udinus.a4510_a11201911862_firmanasdiansyah_utsppb;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {


    EditText editTextEmail;

    EditText editTextPassword;

    //Declaration SqliteHelper
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextEmail = findViewById(R.id.edt_txt_email);

        editTextPassword = findViewById(R.id.edt_txt_password);
        databaseHelper = new DatabaseHelper(this);
    }

    public void clickDaftar(View view) {
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextPassword.getText().toString().trim()))
        {
            Toast.makeText(view.getContext(),"Semua Kolom Masih Kosong, harap isi dahulu.",Toast.LENGTH_LONG).show();
        }

        else
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Kolom E-Mail Tidak Boleh Kosong !!!",Toast.LENGTH_LONG).show();
        }

        else
        if (!isValidEmail(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"E-Mail tidak valid",Toast.LENGTH_LONG).show();
        }


        else
        if(TextUtils.isEmpty(editTextPassword.getText().toString().trim()))
        {
            Toast.makeText(view.getContext(),"Kolom Password Tidak Boleh Kosong !!!",Toast.LENGTH_LONG).show();
        }
        else {
            String Email = editTextEmail.getText().toString();
            String Password = editTextPassword.getText().toString();

            //Check in the database is there any user associated with  this email
            if (!databaseHelper.isEmailExists(Email)) {

                //Email does not exist now add new user to database
                databaseHelper.addUser(new User(null, Email, Password));
                Intent i = new Intent(RegisterActivity.this,RegisterResultActivity.class);
                startActivity(i);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, Snackbar.LENGTH_LONG);
            }else {

                //Email exists with email input provided so show error user already exist
                Toast.makeText(view.getContext(),"Email Sudah ada",Toast.LENGTH_LONG).show();
            }
        }
    }
    public static boolean isValidEmail (CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}
