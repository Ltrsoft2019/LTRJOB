package com.ltrsoft.ltrjob.fragments;

import static java.lang.Thread.sleep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;


public class Splash_Screen extends Fragment {

    public Splash_Screen() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.splash__screen, container, false);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                  LoginFragment login=new LoginFragment();
                  getFragmentManager().beginTransaction().replace(R.id.constraint,login)
                            .addToBackStack(null ).commit();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        return view;
    }
}