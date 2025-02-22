package com.example.eventplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Birthday_Event_2 extends AppCompatActivity {
ImageView item1,item2,item3,item4,item5,item6,item7,item8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_event2);

        item1=(ImageView) findViewById(R.id.item1);
        item2=(ImageView) findViewById(R.id.item2);
        item3=(ImageView) findViewById(R.id.item3);
        item4=(ImageView) findViewById(R.id.item4);
        item5=(ImageView) findViewById(R.id.item5);
        item6=(ImageView)findViewById(R.id.item6);
        item7=(ImageView)findViewById(R.id.item7);
        item8=(ImageView)findViewById(R.id.item8);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(Birthday_Event_2.this, food_1.class);
            startActivity(intent);
            }
        });
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event_2.this, food_2.class);
                startActivity(intent);
            }
        });
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event_2.this, food_3.class);
                startActivity(intent);
            }
        });
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event_2.this, food_4.class);
                startActivity(intent);
            }
        });
        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event_2.this, food_5.class);
                startActivity(intent);
            }
        });
        item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event_2.this, food_6.class);
                startActivity(intent);
            }
        });
        item7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event_2.this, food_7.class);
                startActivity(intent);
            }
        });
        item8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Birthday_Event_2.this, food_8.class);
                startActivity(intent);
            }
        });
    }
}