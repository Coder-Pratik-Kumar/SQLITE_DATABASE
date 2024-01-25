package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    DBmain dbmain;
    TextInputLayout e1,e2;
    AppCompatButton b1,b2;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.username);
        e2=findViewById(R.id.password);
        b1=findViewById(R.id.signup);
        b2=findViewById(R.id.signin);
        img=findViewById(R.id.sql);
        dbmain=new DBmain(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=e1.getEditText().toString();
                String pass=e2.getEditText().toString();

                if(user.isEmpty()||pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Plaese Enter All The Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuser=dbmain.chechusername(user);
                    if(checkuser==false){
                        boolean insert=dbmain.insertdata(user,pass);
                        if (insert==true){
                            Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this,main.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "User Already Exists!Please sign in", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=e1.getEditText().toString();
                String pass=e2.getEditText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(MainActivity.this, "PLAESE ENTER THE FIELDS", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuserpass=dbmain.chechusernamepassword(user,pass);
                    if(checkuserpass==true)
                    {
                        Toast.makeText(MainActivity.this, "SIGN IN SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(MainActivity.this,signin.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "INVALID CREDENTIALS", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}