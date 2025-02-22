package com.example.eventplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
Button btn2,btn1;
EditText et1,et2;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn2=(Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                                        startActivity(intent);
                                        Toast.makeText(MainActivity2.this, "REGISTER HERE", Toast.LENGTH_SHORT).show();
                                    }
                                });
                btn1 = (Button) findViewById(R.id.btn1);

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        et1 = (EditText) findViewById(R.id.et1);
                        et2 = (EditText) findViewById(R.id.et2);

                        String user = et1.getText().toString();
                        String pass = et2.getText().toString();

                        reference = FirebaseDatabase.getInstance().getReference("CUSTOMER");
                        reference.child(user).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                String Username,Password;
                                Username = task.getResult().child("username").getValue().toString();
                                Password = task.getResult().child("password").getValue().toString();
                                    if(pass.equals(Password) && user.equals(Username))
                                    {
                                        Intent intent=new Intent(MainActivity2.this,MainActivity4.class);
                                        startActivity(intent);
                                        Toast.makeText(MainActivity2.this,"WELCOME TO DASHBOARD",Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Toast.makeText(MainActivity2.this,"INVALID USERNAME/PASSWORD",Toast.LENGTH_SHORT).show();
                                    }
                            }
                        });
                    }
                });
        }
    }