package com.udinus.a4510_a11201911862_firmanasdiansyah_utsppb;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText editTextEmail;


    EditText editTextPassword;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editTextEmail = findViewById(R.id.edt_txt_email);

        editTextPassword = findViewById(R.id.edt_txt_password);
        databaseHelper = new DatabaseHelper(this);

    }

    public void clickForgot(View view) {
        Intent i = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(i);
    }

    public void postLogin(View view) {

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
                //Get values from EditText fields
                String Email = editTextEmail.getText().toString();
                String Password = editTextPassword.getText().toString();

                //Authenticate user
                User currentUser = databaseHelper.Authenticate(new User(null, Email, Password));

                //Check Authentication is successful or not
                if (currentUser != null) {

                    //User Logged in Successfully Launch You home screen activity
                    Intent i = new Intent(LoginActivity.this,SuccessActivity.class);
                    startActivity(i);
                    finish();

                } else {

                    Toast.makeText(view.getContext(),"Login Gagal",Toast.LENGTH_LONG).show();

                }

        }
    }


    public static boolean isValidEmail (CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}
