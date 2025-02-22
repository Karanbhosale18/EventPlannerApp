package com.example.eventplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity9 extends AppCompatActivity {
ImageButton ib1,ib2,ib3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        ib1=(ImageButton) findViewById(R.id.ib1);
        ib2=(ImageButton) findViewById(R.id.ib2);
        ib3=(ImageButton) findViewById(R.id.ib3);

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity9.this, contactus.class);
                startActivity(intent);
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity9.this, feedback.class);
                startActivity(intent);
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity9.this, aboutapk.class);
                startActivity(intent);
            }
        });
    }
}