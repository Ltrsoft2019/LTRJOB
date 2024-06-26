package com.ltrsoft.ltrjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.ltrsoft.ltrjob.fragments.DashboardFragment;
import com.ltrsoft.ltrjob.fragments.LoginFragment;
import com.ltrsoft.ltrjob.fragments.NavigationDrawerFragment;
import com.ltrsoft.ltrjob.fragments.PlascreenFragment;

public class MainActivity extends AppCompatActivity {

    public static final String PREF_NAME = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        boolean isFirstLaunch = preferences.getBoolean("flag", true);

        if (isFirstLaunch) {
            showDashboardFragment();
//            Intent intent=new Intent(MainActivity.this, spashscreen.class);
//            startActivity(intent);
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    showDashboardFragment();
//                }
//            }, 5000);
        } else {
            showLoginFragment();
        }
    }

    private void showDashboardFragment() {
        NavigationDrawerFragment dashboardFragment = new NavigationDrawerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.constraint, dashboardFragment).commit();
    }

    private void showLoginFragment() {
        LoginFragment loginFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.constraint, loginFragment).commit();
  }
}
