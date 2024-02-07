package com.ltrsoft.ltrjob.fragments;

import static android.content.Context.MODE_PRIVATE;
import static com.ltrsoft.ltrjob.MainActivity.PREF_NAME;
import static java.lang.Thread.sleep;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Login;


public class PlascreenFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_plashsreen, container, false);


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    SharedPreferences pref = getContext().getSharedPreferences("login", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                  if (pref.getBoolean("flag", false)) {
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id. constraint, new DashboardFragment())

                                .commit();

//
                    }
                  else {
                      getActivity(). getSupportFragmentManager()
                                .beginTransaction()
                            .replace(androidx.constraintlayout.widget.R.id.constraint, new LoginFragment())

                                .commit();
//                    }
                }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        return view;
    }
}