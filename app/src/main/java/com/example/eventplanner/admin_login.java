package com.example.eventplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class admin_login extends AppCompatActivity {
    Button btn2,btn1;
    EditText et1,et2;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        btn2=(Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_login.this, admin_loginn.class);
                startActivity(intent);
                Toast.makeText(admin_login.this, "REGISTER HERE", Toast.LENGTH_SHORT).show();
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

                reference = FirebaseDatabase.getInstance().getReference("ADMIN");
                reference.child(user).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        String Adminname,Password;
                        Adminname = task.getResult().child("username").getValue().toString();
                        Password = task.getResult().child("password").getValue().toString();
                        if(pass.equals(Password) && user.equals(Adminname))
                        {
                            Intent intent=new Intent(admin_login.this,admin_dashboard.class);
                            startActivity(intent);
                            Toast.makeText(admin_login.this,"WELCOME TO DASHBOARD",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(admin_login.this,"INVALID USERNAME/PASSWORD",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}