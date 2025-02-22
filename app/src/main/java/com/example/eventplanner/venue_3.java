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

public class venue_3 extends AppCompatActivity {
    Button url1,btn;
    Spinner spinner1,spinner2;
    EditText et1,firstname,lastname,email,address;
    String item,eventname;
    String EmailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    int no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue3);

        firstname=(EditText)findViewById(R.id.firstname);
        lastname=(EditText)findViewById(R.id.lastname);
        email=(EditText)findViewById(R.id.email);
        address=(EditText)findViewById(R.id.address);
        url1=(Button) findViewById(R.id.url1);
        btn=(Button)findViewById(R.id.btn);
        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        et1=(EditText)findViewById(R.id.et1);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.hr, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.event, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View view, int i, long l) {
                eventname=adapter.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        url1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.thegrandlegacy.net/");
            }
        });

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

                if (m.length() == 10 && Email.matches(EmailValidation) && Firstname!=null && Lastname!=null && Address!=null) {
                    Random r = new Random();
                    no = r.nextInt(1000000);
                    int amount=17499*Integer.parseInt(item);
                    String msg = ("DEAR "+Firstname+" "+Lastname+","+"\nYOUR BOOKING IS CONFIRMED\nBOOKING OTP IS : "+no+"\nBOOKING HOURS : "+item+"HR"+"\nEVENT TYPE : "+eventname+"\nTOTAL BILL : "+amount);
                    Intent i2 = new Intent();
                    PendingIntent pi = PendingIntent.getActivity(venue_3.this, 0, i2, PendingIntent.FLAG_IMMUTABLE);

                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(m, null, msg, pi, null);

                    Toast.makeText(venue_3.this, "VENUE BOOKED", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(venue_3.this,"INVALID INFORMATION",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    private boolean checkPermission(String permission) {
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }
}