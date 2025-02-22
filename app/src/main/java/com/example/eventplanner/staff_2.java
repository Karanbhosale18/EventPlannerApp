package com.example.eventplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Random;

public class staff_2 extends AppCompatActivity {
    Button btn;
    EditText et1,et2,firstname,lastname,email,address,spinner1;
    String item;
    String EmailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    int no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff2);

        firstname=(EditText)findViewById(R.id.firstname);
        lastname=(EditText)findViewById(R.id.lastname);
        email=(EditText)findViewById(R.id.email);
        address=(EditText)findViewById(R.id.address);
        btn=(Button)findViewById(R.id.btn);
        spinner1=(EditText)findViewById(R.id.spinner1);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                String current_date = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());

                String m = et1.getText().toString();
                String Email=email.getText().toString();
                String Firstname=firstname.getText().toString();
                String Lastname=lastname.getText().toString();
                String Address=address.getText().toString();
                int count=Integer.parseInt(et2.getText().toString());
                int hours=Integer.parseInt(spinner1.getText().toString());

                int a=count*hours*1199;

                if (m.length() == 10 && Email.matches(EmailValidation) && Firstname!=null && Lastname!=null && Address!=null) {
                    if (count <= 35) {
                        Random r = new Random();
                        no = r.nextInt(1000000);
                        String msg = ("DEAR " + Firstname + " " + Lastname + "," + "\nYOUR EMPLOYEES ARE BOOKED,\nYOUR OTP IS : " + no +"\nEMPLOYEE TYPE : PART-TIME EMPLOYEES"+"\nREQUIRED EMPLOYEES : "+count+"\nTOTAL BILL : Rs. " + a);

                        Intent i2 = new Intent();
                        PendingIntent pi = PendingIntent.getActivity(staff_2.this, 0, i2, PendingIntent.FLAG_IMMUTABLE);

                        SmsManager sms = SmsManager.getDefault();
                        sms.sendTextMessage(m, null, msg, pi, null);

                        Toast.makeText(staff_2.this, "MESSAGE SEND SUCCESSFULLY", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(staff_2.this,count+" EMPLOYEES ARE NOT AVAILABLE",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(staff_2.this,"INVALID INFORMATION",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean checkPermission(String permission) {
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }
}