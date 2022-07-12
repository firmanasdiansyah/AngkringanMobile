package com.udinus.a4510_a11201911862_firmanasdiansyah_utsppb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PembelianActivity extends AppCompatActivity {

    EditText edt_Nama;
    EditText edt_Jenispesanan;
    EditText edt_Alamat;
    EditText edt_Pesanan;
    EditText edt_Keterangan;
    Button tblAdd;
    Button tblView;
    DatabaseHelper BantuDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelian);

        BantuDb = new DatabaseHelper (this);
        edt_Nama=(EditText)findViewById(R.id.edt_Nama);
        edt_Jenispesanan=(EditText)findViewById(R.id.edt_Jenispesanan);
        edt_Alamat=(EditText)findViewById(R.id.edt_Alamat);
        edt_Pesanan=(EditText)findViewById(R.id.edt_Pesanan);
        edt_Keterangan=(EditText)findViewById(R.id.edt_Keterangan);
        tblAdd=(Button)findViewById(R.id.tblAdd);
        tblView=(Button)findViewById(R.id.tblView);
        viewAll();
        tblAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                boolean isInserted =
                        BantuDb.insertData(edt_Nama.getText().toString(), edt_Jenispesanan.getText().toString(), edt_Alamat.getText().toString(),edt_Pesanan.getText().toString(),edt_Keterangan.getText().toString());

                if (isInserted == true)
                    Toast.makeText(PembelianActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(PembelianActivity.this, "Data gagal Tersimpan",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void   viewAll(){
        tblView.setOnClickListener(
                new  View.OnClickListener() {
                    public void onClick(View v) {
                        Cursor res = BantuDb.getAllData();
                        if (res.getCount() == 0) {
                            showMessage("Eror", "Nothing Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("NAMA :" + res.getString(0) + "\n");
                            buffer.append("JENIS PESANAN :" + res.getString(1) + "\n");
                            buffer.append("ALAMAT :" + res.getString(2) + "\n");
                            buffer.append("PESANAN :" + res.getString(3) + "\n");
                            buffer.append("KETERANGAN :" + res.getString(4) + "\n");
                        }

                        showMessage("ORDERAN", buffer.toString());

                    }
                }
        );
    }
    public void showMessage (String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    }
