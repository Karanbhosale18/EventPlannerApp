package com.example.eventplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class stud_teacher extends AppCompatActivity {
ImageButton client,admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_teacher);

        client=(ImageButton) findViewById(R.id.client);
        admin=(ImageButton) findViewById(R.id.admin);

        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(stud_teacher.this, MainActivity2.class);
                startActivity(i);
                Toast.makeText(stud_teacher.this,"WELCOME TO CLIENT PORTAL",Toast.LENGTH_LONG).show();
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(stud_teacher.this, admin_login.class);
                startActivity(i);
                Toast.makeText(stud_teacher.this,"WELCOME TO ADMIN PORTAL",Toast.LENGTH_LONG).show();
            }
        });
    }
}