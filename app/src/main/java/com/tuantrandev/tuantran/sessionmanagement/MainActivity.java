package com.tuantrandev.tuantran.sessionmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Mapping views
        edtUsername = (EditText)findViewById(R.id.edtUser);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        // Get sharedPreferences
        sp=getSharedPreferences("login",MODE_PRIVATE);
        //if SharedPreferences contains username and password then directly redirect to Home activity
        if(sp.contains("username") && sp.contains("password")){
            startActivity(new Intent(MainActivity.this,Home.class));
            finish();   //finish current activity
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCheck();
            }
        });
    }
    private void loginCheck(){
        //check username and password are correct and then add them to SharedPreferences
        if(edtUsername.getText().toString().equals("tuantran") && edtPassword.getText().toString().equals("thanhtuantn3no1")){
            SharedPreferences.Editor e=sp.edit();
            e.putString("username","tuantran");
            e.putString("password","thanhtuantn3no1");
            e.commit();

            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();

            startActivity(new Intent(MainActivity.this,Home.class));
            finish();
        }
        else{
            Toast.makeText(MainActivity.this,"Incorrect Login Details",Toast.LENGTH_LONG).show();
        }
    }
}
