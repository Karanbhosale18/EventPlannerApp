package com.example.eventplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback extends AppCompatActivity {
EditText et1,et2,et3,et4;
Button btn;
String EmailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
DatabaseReference reference;
FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);
        et4=(EditText) findViewById(R.id.et4);
        btn=(Button) findViewById(R.id.btn);

        database=FirebaseDatabase.getInstance();
        reference=database.getReference("FEEDBACK");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=et1.getText().toString();
                String email=et2.getText().toString();
                String subject=et3.getText().toString();
                String message=et4.getText().toString();

                if(name.length()>=2 && email.matches(EmailValidation) &&  subject.length()>=2 && message.length()>=2) {
                        feedbackdb db = new feedbackdb(name, email, subject, message);
                        reference.child(name).setValue(db);

                        Toast.makeText(feedback.this, "THANK YOU", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(feedback.this, feedback.class);
                        startActivity(intent);

                }else{
                    Toast.makeText(feedback.this,"INVALID DETAILS",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}