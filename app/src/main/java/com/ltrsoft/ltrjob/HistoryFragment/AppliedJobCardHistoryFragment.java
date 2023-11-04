package com.ltrsoft.ltrjob.HistoryFragment;

import android.annotation.SuppressLint;
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
import com.ltrsoft.ltrjob.Adapters.AppliedJobAdapter;
import com.ltrsoft.ltrjob.Classes.Batch_Class;
import com.ltrsoft.ltrjob.Classes.Course_Class;
import com.ltrsoft.ltrjob.Classes.User_JobHistory_Class;
import com.ltrsoft.ltrjob.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppliedJobCardHistoryFragment extends Fragment {
    public AppliedJobCardHistoryFragment(){}

    public RecyclerView applied_recycler;
    public RequestQueue queue;
    public ArrayList<User_JobHistory_Class> list_applied_jobs = new ArrayList<>();
    private static final String APPLIED_JOB_URL = "http://job.ltr-soft.com/user_job_history_read.php";
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.appliedjobhistoryfragment,container,false);
        Toast.makeText(getActivity(), "applied job", Toast.LENGTH_SHORT).show();

        applied_recycler = view.findViewById(R.id.applied_jobs_recycler);
        StringRequest request = new StringRequest(Request.Method.POST, APPLIED_JOB_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
           //     System.out.println("response = "+response.toString());
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0 ;i<jsonArray.length() ; i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String job_desc = jsonObject.getString("job_description");
                        String company_name = jsonObject.getString("company_name");
                        String job_position = jsonObject.getString("job_position");
                        String company_logo = jsonObject.getString("company_logo");
                        String applieddate = jsonObject.getString("created_at");
                        list_applied_jobs.add(new User_JobHistory_Class(job_position,job_desc,company_name,company_logo,applieddate));
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                AppliedJobAdapter adapterClass = new AppliedJobAdapter(list_applied_jobs);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                applied_recycler.setLayoutManager(layoutManager);
                applied_recycler.setAdapter(adapterClass);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Error = "+error.toString(), Toast.LENGTH_SHORT).show();
                System.out.println("error = "+error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap<>();
                map.put("user_id","user-17");
                return map;
            }
        };
        queue = Volley.newRequestQueue(getContext());
        queue.add(request);


        return view;
    }
}
