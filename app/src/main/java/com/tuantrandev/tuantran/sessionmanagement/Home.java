package com.tuantrandev.tuantran.sessionmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView tvHome, tvWelcome;
    Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Mapping views
        tvHome = (TextView)findViewById(R.id.tvHome);
        tvWelcome = (TextView)findViewById(R.id.tvWelcome);
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor e=sp.edit();
                e.clear();
                e.apply();
                startActivity(new Intent(Home.this,MainActivity.class));
                finish();   //finish current activity
            }
        });
    }

}
