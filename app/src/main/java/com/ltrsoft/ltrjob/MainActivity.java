package com.ltrsoft.ltrjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.ltrsoft.ltrjob.fragments.LoginFragment;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences=getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        if(preferences.getBoolean("flag",true)){
            LoginFragment loginFragment=new LoginFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.constraint, loginFragment).commit();
        }
        else {

            LoginFragment loginFragment=new LoginFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.constraint, loginFragment).commit();
        }





          }
}