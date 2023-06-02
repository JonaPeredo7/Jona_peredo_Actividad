package com.example.jona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity
{

    Button btnTelefono, btnGmail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnGmail = findViewById(R.id.btnGmail);
        btnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {EmailEnviado();}
        });



        btnTelefono = findViewById(R.id.btnTelefono);
        btnTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numeroTelefono = "+542954320028";
                dialLlamarProgramdor(numeroTelefono);
            }
        });

    }

    public void EmailEnviado() {
        String[] recipient = {"jonathn.peredo.13@gmail.com"};

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + Uri.encode(recipient[0])));
        intent.putExtra(Intent.EXTRA_EMAIL, recipient);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(Intent.createChooser(intent, "Enviar correo en: "));
    }

    private void dialLlamarProgramdor(String numeroTelefono){
        Uri uri = Uri.parse("tel:" + numeroTelefono);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);

        if(intent.resolveActivity(getPackageManager()) !=  null){
            startActivity(intent);
        }
    }
}



