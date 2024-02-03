package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Course_Class;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseDetailFragment extends Fragment {
    public CourseDetailFragment(){}
    TextView fullcourse,java,duration,fees,about,discryption,include,details,mode;
    Button apply_now;
    ImageView imageView;
    ArrayList one_time_fees=new ArrayList<>();
    ArrayList course_description=new ArrayList<>();
    Course_Class courseClass=new Course_Class();
    String URL1="http://job.ltr-soft.com/course_detail.php";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.coursedetailfragment,container,false);
       // Toast.makeText(getActivity(), "course detail", Toast.LENGTH_SHORT).show();
        fullcourse=view.findViewById(R.id.fullcourse);
        java=view.findViewById(R.id.java);
        duration=view.findViewById(R.id.days);
        fees=view.findViewById(R.id.fees);
        about=view.findViewById(R.id.aboutcourse);
        discryption=view.findViewById(R.id.coursedetails);
        include=view.findViewById(R.id.includes);
        details=view.findViewById(R.id.include_details);
        mode=view.findViewById(R.id.mode);
        apply_now=view.findViewById(R.id.join);
        imageView=view.findViewById(R.id.wipro);

        Bundle args = getArguments();

        String course_id= args.getString("course_id");
        courseClass.setCourse_id(course_id);


        fullcourse.setText("full course");


        mode.setText("Mode:offline");
        // Use the value as neede

        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        StringRequest stringRequest=new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Toast.makeText(getActivity(), "" + response, Toast.LENGTH_LONG).show();
                        try {
                            JSONArray json = new JSONArray(response);
                            for (int i=0;i<json.length();i++){
                                JSONObject jsonObject1=  json.getJSONObject(i);
                                String   course_description= jsonObject1.optString("course_description");
                                String one_time_fees =jsonObject1.optString("one_time_fees");
                               String course_name1=jsonObject1.optString("course_name");
                              String  course_duration1= jsonObject1.optString("course_duration");
                                 // System.out.println("system.out="+ course_id+   course_duration+   course_name);
                                // Courses_data_class coursesDataClass=new Courses_data_class(course_id,course_name,course_type,course_duration);
                                java.setText( courseClass.setCourse_name(course_name1));
                                duration.setText( courseClass.setCourse_duration(course_duration1));
                                discryption.setText(courseClass.setCourse_description(course_description));
                                fees.setText(courseClass.setFees(one_time_fees));

                            }



                        }
                        catch (Exception e)
                        {
                            // Toast.makeText(getActivity(), "here is a error", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), ""+error, Toast.LENGTH_SHORT).show();
                    }
                }

        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();
                map.put("course_id",course_id);
                return map;
            }
        };

        requestQueue.add(stringRequest);





        apply_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
              //  fragmentTransaction.replace(R.id.container,new Course_congratulation_page());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        return view;
    }
}
