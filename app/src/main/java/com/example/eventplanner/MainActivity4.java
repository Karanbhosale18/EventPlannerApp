package com.example.eventplanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.zip.Inflater;

public class MainActivity4 extends AppCompatActivity{
    private DrawerLayout drawerLayout;
    Toolbar toolbar;
    private NavigationView navigationView;
    ImageButton BirthdayEvent,WeddingEvent,WeddingAnniversaryEvent,FamilyEvent,vipevent,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        navigationView=(NavigationView)findViewById(R.id.navigation);
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        navigationView=(NavigationView) findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemid=item.getItemId();
                if(itemid==R.id.dashboard)
                {
                    Intent intent=new Intent(MainActivity4.this,MainActivity4.class);
                    startActivity(intent);
                }
                else if (itemid==R.id.registration) {
                    Intent intent=new Intent(MainActivity4.this,MainActivity3.class);
                    startActivity(intent);
                }
                else if (itemid==R.id.login) {
                    Intent intent=new Intent(MainActivity4.this, MainActivity2.class);
                    startActivity(intent);
                }
                else if (itemid==R.id.logout) {

                }
                return false;
            }
        });
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        BirthdayEvent=(ImageButton) findViewById(R.id.BirthdayEvent);
        WeddingEvent=findViewById(R.id.WeddingEvent);
        WeddingAnniversaryEvent=findViewById(R.id.WeddingAnniversaryEvent);
        FamilyEvent=findViewById(R.id.FamilyEvent);
        vipevent=findViewById(R.id.vipevent);
        about=findViewById(R.id.about);

        BirthdayEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(MainActivity4.this, Birthday_Event.class);
            startActivity(intent);
                Toast.makeText(MainActivity4.this,"BIRTHDAY EVENT",Toast.LENGTH_SHORT).show();
            }
        });
        WeddingEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(intent);
                Toast.makeText(MainActivity4.this,"WEDDING EVENT",Toast.LENGTH_SHORT).show();
            }
        });
        WeddingAnniversaryEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity4.this, MainActivity6.class);
                startActivity(intent);
                Toast.makeText(MainActivity4.this,"ANNIVERSARY EVENT",Toast.LENGTH_SHORT).show();
            }
        });
        FamilyEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity4.this, MainActivity7.class);
                startActivity(intent);
                Toast.makeText(MainActivity4.this,"AWARD CEREMONIES",Toast.LENGTH_SHORT).show();
            }
        });
        vipevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity4.this, MainActivity8.class);
                startActivity(intent);
                Toast.makeText(MainActivity4.this,"COMPANY PARTIES",Toast.LENGTH_SHORT).show();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity4.this, MainActivity9.class);
                startActivity(intent);

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == (R.id.dashboard)) {

        } else if (item.getItemId() == R.id.registration) {
            Intent i2 = new Intent(MainActivity4.this, MainActivity3.class);
            startActivity(i2);
        } else if (item.getItemId() == R.id.login) {
            Intent i3 = new Intent(MainActivity4.this, MainActivity2.class);
            startActivity(i3);
        }else if (item.getItemId() == R.id.logout) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        return super.onOptionsItemSelected(item);
    }
}
