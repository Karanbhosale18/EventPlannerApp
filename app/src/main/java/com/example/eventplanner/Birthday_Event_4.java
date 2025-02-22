package com.example.eventplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Birthday_Event_4 extends AppCompatActivity {
ImageView item1,item2,item3,item4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_event4);

        item1=(ImageView) findViewById(R.id.item1);
        item2=(ImageView) findViewById(R.id.item2);
        item3=(ImageView) findViewById(R.id.item3);
        item4=(ImageView) findViewById(R.id.item4);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event_4.this, staff_1.class);
                startActivity(intent);
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event_4.this, staff_2.class);
                startActivity(intent);
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event_4.this, staff_3.class);
                startActivity(intent);
            }
        });

        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event_4.this, staff_4.class);
                startActivity(intent);
            }
        });
    }
}