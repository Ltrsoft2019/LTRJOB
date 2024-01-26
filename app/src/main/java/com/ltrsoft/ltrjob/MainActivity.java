package com.ltrsoft.ltrjob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ltrsoft.ltrjob.fragments.LoginFragment;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginFragment loginFragment=new LoginFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.constraint, loginFragment).commit();




          }
}