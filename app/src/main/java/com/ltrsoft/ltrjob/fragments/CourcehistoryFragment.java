package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Batch_Deo;
import com.ltrsoft.ltrjob.daoclasses.Cources_Deo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Batch;
import com.ltrsoft.ltrjob.pojoclass.Course_Class;

import java.util.ArrayList;


public class CourcehistoryFragment extends Fragment {
    TextView fullcourse,java,start,end,fees,about,discryption,include,details,mode,duration;
    Button apply_now;
    ImageView imageView,back;
    ArrayList<Batch>list;
    ArrayList<Course_Class>list1;
    Batch batch;
    Course_Class courseClass;
    String batch_id,course_id;

    public CourcehistoryFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_courcehistory, container, false);



        fullcourse=view.findViewById(R.id.fullcourse);
        java=view.findViewById(R.id.java);
        start=view.findViewById(R.id.start);
        end = view.findViewById(R.id.end);
        fees=view.findViewById(R.id.fees);
        about=view.findViewById(R.id.aboutcourse);
        discryption=view.findViewById(R.id.coursedetails);
        include=view.findViewById(R.id.includes);
        details=view.findViewById(R.id.include_details);
        mode=view.findViewById(R.id.mode);
        imageView=view.findViewById(R.id.logo );
        duration = view.findViewById(R.id.duration);

        back = view.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardFragment dashboardFragment = new DashboardFragment();
                getFragmentManager().beginTransaction().replace(R.id.container,dashboardFragment).commit();
            }
        });
        Bundle args = getArguments();

        if (args!=null) {

            batch_id = args.getString("batch_id", "");
            course_id = args.getString("course_id","");

        }

        Toast.makeText(getContext(), "new cour="+course_id, Toast.LENGTH_SHORT).show();

        Batch_Deo batchDeo = new Batch_Deo();

        batchDeo.getoneBatch(getContext(), "batch-1", new UserCallBack() {
            @Override
            public void userSuccess(Object object) {

                list= (ArrayList<Batch>) object;

                for (int i = 0; i < list.size(); i++) {
                    batch=list.get(i);


                    fees.setText(batch.getOne_time_fees());
                    end.setText(batch.getBatch_end_date());
                    start.setText(batch.getBatch_start_date());
                }
            }
            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "Error= "+error, Toast.LENGTH_SHORT).show();
            }
        });

        Cources_Deo courcesDeo=new Cources_Deo();

        courcesDeo.getcorces1(getContext(), course_id, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                list1= (ArrayList<Course_Class>) object;
                Toast.makeText(getContext(), "size = "+list1.size(), Toast.LENGTH_SHORT).show();
                for (int i = 0; i <list1.size() ; i++) {
                    courseClass = list1.get(i);
                    discryption.setText(courseClass.getCourse_description());
                    java.setText(courseClass.course_name);
                    duration.setText(courseClass.course_duration);


                }
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}