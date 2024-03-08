package com.ltrsoft.ltrjob.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Resume;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.User;
import com.ltrsoft.ltrjob.pojoclass.Userclass;
import com.squareup.picasso.Picasso;

public class NavigationDrawerFragment extends Fragment {
    public DrawerLayout drawerLayout;
    public Toolbar toolbar;
    public NavigationView navigationView;
    public ActionBarDrawerToggle toggle;

    private TextView name;
    private ImageView profile;

    public NavigationDrawerFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.navigationfragment, container, false);

        toolbar = v.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        navigationView = v.findViewById(R.id.navigation);
        drawerLayout = v.findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        DashboardFragment dashboardFragment = new DashboardFragment();
        getFragmentManager().beginTransaction().add(R.id.container, dashboardFragment).commit();

        name = navigationView.getHeaderView(0).findViewById(R.id.name);
        profile = navigationView.getHeaderView(0).findViewById(R.id.profile);
        Resume resume = new Resume();

        resume.getall(getContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                Object[] objects = (Object[]) object;
                Userclass user = (Userclass) objects[0];

//                String profile= user.getUser_photo();
//                String name = user.getUser_fname();

                name.setText(user.getUser_fname());
                String imgUrl = "https://institute.ltr-soft.com/company_details/" + user.getUser_photo();
                Picasso.get().load(imgUrl).into(profile);

            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "errr" + error, Toast.LENGTH_SHORT).show();
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);


                if (id == R.id.sidenav_home) {
                    DashboardFragment dashboardFragment = new DashboardFragment();
                    getFragmentManager().beginTransaction().replace(R.id.container, dashboardFragment).addToBackStack(null).commit();
                } else if (id == R.id.sidenav_exam) {
                    getFragmentManager().beginTransaction().replace(R.id.container, new ExamCardDispalyFragment()).addToBackStack(null).commit();
                } else if (id == R.id.sidenav_event) {
                    getFragmentManager().beginTransaction().replace(R.id.container, new EventCardDispaFragment()).addToBackStack(null).commit();
                } else if (id == R.id.sidenav_certification) {
                    getFragmentManager().beginTransaction().add(R.id.container, new CertificationFragment()).addToBackStack(null).commit();
                    Toast.makeText(getActivity(), "Not create Fragment", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.sidenav_course) {
                    getFragmentManager().beginTransaction().replace(R.id.container, new CourceFragment()).addToBackStack(null).commit();
                } else if (id == R.id.sidenav_history) {
                    getFragmentManager().beginTransaction().replace(R.id.container, new HistoryFragment()).addToBackStack(null).commit();
                } else if (id == R.id.sidenav_plans) {
//                    getFragmentManager().beginTransaction().replace(R.id.constraint, new ExamCardDispalyFragment()).addToBackStack(null).commit();
                    Toast.makeText(getActivity(), "Not create Fragment", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.sidenav_feedback) {
                    getFragmentManager().beginTransaction().replace(R.id.container, new FeedbacFragment()).addToBackStack(null).commit();
                    Toast.makeText(getActivity(), "Not create Fragment", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.sidenav_resume) {
                    getFragmentManager().beginTransaction().replace(R.id.container, new ResumeFragment()).addToBackStack(null).commit();

                } else if (id == R.id.sidenav_setting) {
                    getFragmentManager().beginTransaction().add(R.id.constraint, new SettingFragment()).addToBackStack(null).commit();
                    Toast.makeText(getActivity(), "Not create Fragment", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.sidenav_setting) {
                    getFragmentManager().beginTransaction().add(R.id.constraint, new SettingFragment()).addToBackStack(null).commit();
                    Toast.makeText(getActivity(), "Not create Fragment", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.Profile) {
                    getFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragment()).addToBackStack(null).commit();


                } else if (id == R.id.news) {
                    getFragmentManager().beginTransaction().replace(R.id.container, new NewsFragment()).addToBackStack(null).commit();


                } else if (id == R.id.nav_logout) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Logout Dialogue");
                    builder.setMessage("Do You Want To Logout?");
                    builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            logout(); // Perform logout actions
//                            LoginFragment loginFragment = new LoginFragment();
//                            getChildFragmentManager().beginTransaction().replace(R.id.container, loginFragment).commit();
                        }

                        private void logout() {

                                LoginFragment loginFragment = new LoginFragment();
                                getChildFragmentManager().beginTransaction().replace(R.id.container, loginFragment).commit();

                            }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;


            }
        });
        return v;
    }
}
