package com.ltrsoft.ltrjob.CoursesFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.Adapters.CourseCardAdapter;
import com.ltrsoft.ltrjob.Classes.Course_Class;
import com.ltrsoft.ltrjob.R;

import org.json.JSONArray;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;


public class CourseCardDisplayFragment extends Fragment {
    String URL="https://job.ltr-soft.com/course_card.php";
    public RecyclerView recyclerView;
    public ImageView contextmenu;
    ArrayList<Course_Class> arrayList=new ArrayList<>();

    public CourseCardDisplayFragment(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.coursecarddisplayfragment,container,false);
        View view = inflater.inflate(R.layout.coursecarddisplayfragment, container, false);
        recyclerView=view.findViewById(R.id.fragment_recycler_courses);

        arrayList.clear();

        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        StringRequest stringRequest=new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Toast.makeText(getActivity(), "" + response, Toast.LENGTH_LONG).show();
                        String course_id,course_name,course_type,course_duration;
                        try {
                            JSONArray json = new JSONArray(response);
                            for (int i=0;i<json.length();i++){
                                JSONObject jsonObject1=  json.getJSONObject(i);
                                course_id= jsonObject1.optString("course_id");
                                course_name=jsonObject1.optString("course_name");
                                course_duration= jsonObject1.optString("course_duration");
                                course_type="full course";
                                // System.out.println("system.out="+ course_id+   course_duration+   course_name);
                                Course_Class coursesDataClass=new Course_Class(course_id,course_name,course_duration,null,null,null,null);
                                arrayList.add(coursesDataClass);

                            }
                           CourseCardAdapter adapterclass=new CourseCardAdapter(arrayList);
                            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(adapterclass);
                            adapterclass.notifyDataSetChanged();


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

        );

        requestQueue.add(stringRequest);



        return view;
    }

}
