package com.ltrsoft.ltrjob.HistoryFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.Adapters.AppliedCourseAdapter;
import com.ltrsoft.ltrjob.Classes.Course_Class;
import com.ltrsoft.ltrjob.Classes.User_Course_Class;
import com.ltrsoft.ltrjob.Classes.User_JobHistory_Class;
import com.ltrsoft.ltrjob.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppliedCoursesCardHistroryFragment extends Fragment {
    public AppliedCoursesCardHistroryFragment(){}
    public RecyclerView applied_course_recycler;
    public RequestQueue queue;
    public ArrayList<User_Course_Class> list_applied_jobs = new ArrayList<>();
    private static final String APPLIED_COURSE_URL = "http://job.ltr-soft.com/batch_read.php";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.appliedcoursehistoryfragment,container,false);
        Toast.makeText(getActivity(), "applied courses", Toast.LENGTH_SHORT).show();

        applied_course_recycler = v.findViewById(R.id.applied_course_recycler);

        StringRequest request = new StringRequest(Request.Method.POST, APPLIED_COURSE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              //  System.out.println("response = "+response.toString());

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0 ;i<jsonArray.length() ; i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String course_name = jsonObject.getString("course_name");
                        String course_description = jsonObject.getString("course_description");
                        String course_duration = jsonObject.getString("course_duration");
                        //String batch_end_date = jsonObject.getString("batch_end_date");
                       // String course_img = jsonObject.getString("course_img");
                        list_applied_jobs.add(new User_Course_Class(course_name,course_duration,course_description,"inputfiles/img1.jpeg"));
                    }
                } catch (JSONException e) {
                    Toast.makeText(getContext(), "v error = "+e.toString(), Toast.LENGTH_SHORT).show();
                    throw new RuntimeException(e);
                }

                AppliedCourseAdapter adapter = new AppliedCourseAdapter(list_applied_jobs);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                applied_course_recycler.setLayoutManager(layoutManager);
                applied_course_recycler.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error = "+error.toString(), Toast.LENGTH_SHORT).show();
                System.out.println("Error = "+error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap <String,String> map = new HashMap<>();
                map.put("user_id","user-17");
                return map;
            }
        };
        queue= Volley.newRequestQueue(getContext());
        queue.add(request);
        return v;
    }
}
