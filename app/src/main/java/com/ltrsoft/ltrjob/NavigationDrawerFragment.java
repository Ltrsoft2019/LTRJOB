package com.ltrsoft.ltrjob;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerFragment extends Fragment {
    public DrawerLayout drawerLayout;
    public Toolbar toolbar;
    public NavigationView navigationView;
    public ActionBarDrawerToggle toggle;
    public NavigationDrawerFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.navigationfragment,container,false);
        toolbar = v.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        navigationView = v.findViewById(R.id.navigation);
        drawerLayout = v.findViewById(R.id.drawer);
//        toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();

        toggle = new ActionBarDrawerToggle(getActivity() , drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        return v;
    }
}
