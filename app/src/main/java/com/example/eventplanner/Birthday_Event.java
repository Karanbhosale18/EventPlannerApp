package com.example.eventplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Birthday_Event extends AppCompatActivity {
ImageButton venue,food,cake,staff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_event);

        venue=(ImageButton) findViewById(R.id.venue);
        venue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event.this, Birthday_Event_1.class);
                startActivity(intent);
            }
        });

        food=(ImageButton) findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event.this, Birthday_Event_2.class);
                startActivity(intent);
            }
        });

        cake=(ImageButton) findViewById(R.id.cake);
        cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event.this, Birthday_Event_3.class);
                startActivity(intent);
            }
        });

        staff=(ImageButton) findViewById(R.id.staff);
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event.this, Birthday_Event_4.class);
                startActivity(intent);
            }
        });
    }
}