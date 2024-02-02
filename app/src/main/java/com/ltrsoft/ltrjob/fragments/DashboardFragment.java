package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.ltrsoft.ltrjob.Adpter.DashboardJobCardAdapter;
import com.ltrsoft.ltrjob.Adpter.DashboardNewsAdapter;
import com.ltrsoft.ltrjob.Adpter.EventCardAdapter;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.JobDashboard;
import com.ltrsoft.ltrjob.daoclasses.NewsPhotoDeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Event_class;
import com.ltrsoft.ltrjob.pojoclass.News_Photo;
import com.ltrsoft.ltrjob.pojoclass.job;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DashboardFragment extends Fragment {
    private RecyclerView recyclerView1,recyclerView2;

    public DashboardFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recyclerView1 = view.findViewById(R.id.dashboard_horizontal_recycler);
recyclerView2=view.findViewById(R.id.dashboard_verticle_recycler);

        NewsPhotoDeo eventCard = new NewsPhotoDeo();

        eventCard.fatchphoto(requireContext(), recyclerView1, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<News_Photo> list = (ArrayList<News_Photo>) object;

                ArrayList<job> list1 = (ArrayList<job>) object;


                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

                DashboardNewsAdapter adapter = new DashboardNewsAdapter(list);

                recyclerView1.setLayoutManager(layoutManager);
                recyclerView1.setAdapter(adapter);
                LinearSnapHelper snapHelper = new LinearSnapHelper();
                snapHelper.attachToRecyclerView(recyclerView1);

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (layoutManager.findLastCompletelyVisibleItemPosition() < (adapter.getItemCount() - 1)) {
                            layoutManager.smoothScrollToPosition(recyclerView1, new RecyclerView.State(),
                                    layoutManager.findLastCompletelyVisibleItemPosition() + 1);
                        } else if (layoutManager.findLastCompletelyVisibleItemPosition() == adapter.getItemCount()) {
                            layoutManager.smoothScrollToPosition(recyclerView1, new RecyclerView.State(),
                                    layoutManager.findLastCompletelyVisibleItemPosition() - adapter.getItemCount());
                        }
                    }
                }, 0, 3000);
            }

            @Override
            public void userError(String error) {
                // Handle error, you can show a Toast or perform other error handling actions
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });
//




        JobDashboard jobDashboard = new JobDashboard();

        jobDashboard.getall(requireContext(), recyclerView2, new UserCallBack() {
            @Override
            public void userSuccess(Object object1) {
                ArrayList<job> list1 = (ArrayList<job>) object1;
                LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
                DashboardJobCardAdapter adapter1 = new DashboardJobCardAdapter(list1);
                recyclerView2.setLayoutManager(layoutManager1);
                recyclerView2.setAdapter(adapter1);



                // Example: Navigate to AnotherFragment
//                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, new AnotherFragment());
//                transaction.addToBackStack(null);
//                transaction.commit();

            }

            @Override
            public void userError(String error) {
                // Handle error for the second RecyclerView, if needed
            }
        });

        return view;


    }
}
