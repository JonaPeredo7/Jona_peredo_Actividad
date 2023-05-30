package com.example.jona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button btnTelefono, btnGmail;
    String url = "https://github.com/JonaPeredo7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        referenciaViews();
    }

    public void referenciaViews() {
        btnTelefono = findViewById(R.id.btnTelefono);
        btnGmail = findViewById(R.id.btnGmail);

        btnTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(Intent.ACTION_CALL);
              intent.setData(Uri.parse("tel:+542954320028"));
              startActivity(intent);
            }

        });

        btnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             URI _link = Uri.parse(url);
             Intent i =  new Intent(Intent.ACTION_VIEW, _link);
                 startActivity(i);
            }
        });
    }

}
