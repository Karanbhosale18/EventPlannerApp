package com.example.eventplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

Button btn,btn1;
int no;
EditText et1,et2,et3,et4,et5,et6;
FirebaseDatabase database;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn=(Button) findViewById(R.id.btn);
        et1=(EditText)findViewById(R.id.et1);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        et5=(EditText)findViewById(R.id.et5);
        et6=(EditText)findViewById(R.id.et6);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database=FirebaseDatabase.getInstance();
                reference=database.getReference("CUSTOMER");

                String username=et1.getText().toString();
                String mobileno=et2.getText().toString();
                String email=et3.getText().toString();
                String password=et4.getText().toString();
                String conpass=et5.getText().toString();
                int otp=Integer.parseInt(et6.getText().toString());

                String EmailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String PassValidation = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,16}$";

                if(username.length()>1 && mobileno.length()==10 && email.matches(EmailValidation) && password.matches(PassValidation) && conpass.equals(password) && otp==no ) {

                    registration res=new registration(username,mobileno,email,password);
                    reference.child(username).setValue(res);

                    Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity3.this, "WELCOME TO DASHBOARD", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity3.this,"INVALID DETAILS",Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        btn1=(Button) findViewById(R.id.btn1);
        et2=(EditText) findViewById(R.id.et2);
        if(checkPermission(android.Manifest.permission.SEND_SMS)){
            btn1.setEnabled(true);
        }else{
            ActivityCompat.requestPermissions(MainActivity3.this,new String[]{Manifest.permission.SEND_SMS},1);
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m = et2.getText().toString();
                Random r = new Random();
                no = r.nextInt(1000000);
                String msg=("HELLO SIR !!!\n" +
                        "YOUR OTP IS : "+no);

                Intent i2 = new Intent();
                PendingIntent pi = PendingIntent.getActivity(MainActivity3.this, 0, i2, PendingIntent.FLAG_IMMUTABLE);

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(m, null, msg, pi, null);

                Toast.makeText(MainActivity3.this, "Message Sent Successfully", Toast.LENGTH_LONG).show();
            }

        });
    }

    private boolean checkPermission(String permission) {
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }
}