package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class signin extends AppCompatActivity {

    TextInputEditText e1,e2;
    AppCompatButton b2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        e1=findViewById(R.id.username);
        e2=findViewById(R.id.password);

        b2=findViewById(R.id.signin);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(signin.this,main.class);
            startActivity(intent);
            }
        });

    }
}