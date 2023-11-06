package com.ltrsoft.ltrjob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ltrsoft.ltrjob.LoginRegistrationOprationFragment.LoginFragment;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginFragment loginFragment=new LoginFragment();
//        NavigationDrawerFragment loginFragment=new NavigationDrawerFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.constraint, loginFragment).commit();

    }
}