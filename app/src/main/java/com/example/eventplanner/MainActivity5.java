package com.example.eventplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity5 extends AppCompatActivity {
ImageButton venue,food,cake,staff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        venue=(ImageButton) findViewById(R.id.venue);
        food=(ImageButton) findViewById(R.id.food);
        cake=(ImageButton) findViewById(R.id.cake);
        staff=(ImageButton) findViewById(R.id.staff);

        venue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity5.this, Birthday_Event_1.class);
                startActivity(intent);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity5.this, Birthday_Event_2.class);
                startActivity(intent);
            }
        });
        cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity5.this, Birthday_Event_3.class);
                startActivity(intent);
            }
        });
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity5.this, Birthday_Event_4.class);
                startActivity(intent);
            }
        });
    }
}