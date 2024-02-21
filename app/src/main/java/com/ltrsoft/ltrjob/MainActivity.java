package com.ltrsoft.ltrjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.ltrsoft.ltrjob.fragments.DashboardFragment;
import com.ltrsoft.ltrjob.fragments.LoginFragment;
import com.ltrsoft.ltrjob.fragments.PlascreenFragment;
import com.ltrsoft.ltrjob.fragments.Splash_Screen;

public class MainActivity extends AppCompatActivity {

    public static final String PREF_NAME = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Splash_Screen splashScreen=new Splash_Screen();
getSupportFragmentManager().beginTransaction().replace(R.id.constraint, splashScreen).commit();


    }




}
