package com.example.simplealert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText nomorTelpon;
    Spinner menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomorTelpon = findViewById(R.id.telpNum);
        menu = findViewById(R.id.dropMenu);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.listSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menu.setAdapter(adapter);
    }
    public void alertNotif(View view) {
        String nomorTelp = nomorTelpon.getText().toString();
        String pesan = "Nomor Telp Anda " + nomorTelp + "?" + "\nKlik OK Jika Benar, Klik CANCEL Jika Salah";
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert!");
        builder.setMessage(pesan);
        builder.setPositiveButton("OK", (dialog, which) -> {
            finish();
        });
        builder.setNegativeButton("CANCEL", (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}