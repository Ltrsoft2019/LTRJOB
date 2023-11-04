package com.ltrsoft.ltrjob.CoursesFragment;

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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class  CourseDetailFragment extends Fragment {
    public CourseDetailFragment(){}
    TextView course_type,course_name,duration,fees,about,discryption,include,details,mode;
    Button apply_now;
    ImageView imageView;
    ArrayList one_time_fees=new ArrayList<>();
    ArrayList course_description=new ArrayList<>();
    String URL1="http://job.ltr-soft.com/course_detail.php";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.coursedetailfragment,container,false);
       // Toast.makeText(getActivity(), "course detail", Toast.LENGTH_SHORT).show();
        course_type=view.findViewById(R.id.course__type);
        course_name=view.findViewById(R.id.course__name);
        duration=view.findViewById(R.id.course_duration);
        fees=view.findViewById(R.id.fees);
        about=view.findViewById(R.id.about);
        discryption=view.findViewById(R.id.discryption);
        include=view.findViewById(R.id.course_include);
        details=view.findViewById(R.id.include_details);
        mode=view.findViewById(R.id.mode);
        apply_now=view.findViewById(R.id.apply_now);
        imageView=view.findViewById(R.id.imageView);
        Bundle args = getArguments();

        String course_id= args.getString("course_id");
        String course_type1= args.getString("course_type");
        String course_name1= args.getString("course_name");
        String course_duration1= args.getString("course_duration");
        course_type.setText(course_type1);
        course_name.setText(course_name1);
        duration.setText(course_duration1);

        mode.setText("offline");
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

                                // System.out.println("system.out="+ course_id+   course_duration+   course_name);
                                // Courses_data_class coursesDataClass=new Courses_data_class(course_id,course_name,course_type,course_duration);
                                discryption.setText(course_description);
                                fees.setText(one_time_fees);

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
                fragmentTransaction.replace(R.id.container,new Course_congratulation_page());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        return view;
    }
}
