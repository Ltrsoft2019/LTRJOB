package com.ltrsoft.ltrjob;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.AutoScrollHelper;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.Adapters.DashboardImageAdapter;
import com.ltrsoft.ltrjob.Adapters.DashboardJobCardAdapter;
import com.ltrsoft.ltrjob.Classes.DashboardImageClass;
import com.ltrsoft.ltrjob.Classes.Dashboard_job_Class;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class DashboardFragment extends Fragment {
    public DashboardFragment(){

    }
    public TextView dash_name;
    public ImageView dash_img;
    public RecyclerView dashboard_verticle_recycler,dashboard_horizontal_recycler;
    public ArrayList<Dashboard_job_Class> listofjob = new ArrayList<>();
    public ArrayList<DashboardImageClass> listofimg = new ArrayList<>();
    public  RequestQueue queue;

    public final static String DASHBOARD_JOB_URL = "http://job.ltr-soft.com/Dashboard_job_Recycle.php";
    public final static String DASHBOARD_IMG_URL = "http://job.ltr-soft.com/Dashboard_image.php";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.dashboardfragment,container,false);
        queue= Volley.newRequestQueue(getContext());
        Toast.makeText(getActivity(), "dashboard", Toast.LENGTH_SHORT).show();
        dash_name = v.findViewById(R.id.dashbord_name);
        dash_img = v.findViewById(R.id.dashboard_img);
        dashboard_horizontal_recycler = v.findViewById(R.id.dashboard_horizontal_recycler);
        dashboard_verticle_recycler = v.findViewById(R.id.dashboard_verticle_recycler);
        listofjob.clear();
        listofimg.clear();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, DASHBOARD_JOB_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
          //  System.out.println("response = "+response.toString());
            for (int i = 0 ; i < response.length() ; i++){
                try {
                    JSONObject jsonObject = response.getJSONObject(i);
                    String jobcatgory = jsonObject.getString("job_category_id");
                    String job_position = jsonObject.getString("job_position");
                    String company_name = jsonObject.getString("company_name");
                    String company_logo_path = jsonObject.getString("company_logo");
                    String job_post_date = jsonObject.getString("created_at");
                    String job_id = jsonObject.getString("job_id");
                    String job_description = jsonObject.getString("job_description");
                    String job_start_date_to_apply = jsonObject.getString("job_start_date_to_apply");
                    String job_criteria_to_apply = jsonObject.getString("job_criteria_to_apply");
                    String job_end_date_to_apply = jsonObject.getString("job_end_date_to_apply");
                    String job_website_to_apply = jsonObject.getString("job_website_to_apply");
                    String company_email = jsonObject.getString("company_email");
                    String company_phone = jsonObject.getString("company_phone");
                    String company_domain = jsonObject.getString("company_domain");
                    String company_hoaddress = jsonObject.getString("company_hoaddress");
                    String job_salary = jsonObject.getString("job_salary");
                    String company_hodistrict = jsonObject.getString("company_hodistrict");
                    String company_hostate = jsonObject.getString("company_hostate");
                    String company_hocountry = jsonObject.getString("company_hocountry");
                    listofjob.add(new Dashboard_job_Class(job_id,job_website_to_apply,job_start_date_to_apply,job_end_date_to_apply,job_position,job_salary,
                            job_description,job_criteria_to_apply,company_name,company_logo_path,company_email,company_phone,company_domain,company_hoaddress,company_hoaddress
                    ,company_hodistrict,company_hostate,company_hocountry));
                } catch (JSONException e) {
                    Toast.makeText(getContext(), "error = "+e.toString(), Toast.LENGTH_SHORT).show();
                    throw new RuntimeException(e);
                }
            }
                DashboardJobCardAdapter  adapter = new DashboardJobCardAdapter(listofjob);
                dashboard_verticle_recycler.setAdapter(adapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                dashboard_verticle_recycler.setLayoutManager(layoutManager);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Error = "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
        // Request for Dashboard Verticle Recycler View


        JsonArrayRequest jsonArrayRequest1 = new JsonArrayRequest(Request.Method.POST, DASHBOARD_IMG_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0 ; i < response.length() ; i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String img_path = jsonObject.getString("notification_photo_path");
                        System.out.println("path = "+img_path);
                        listofimg.add(new DashboardImageClass(img_path));
                    } catch (JSONException e) {
                        Toast.makeText(getContext(), "error = "+e.toString(), Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }
                }
                DashboardImageAdapter adapter = new DashboardImageAdapter(listofimg);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
                dashboard_horizontal_recycler.setLayoutManager(layoutManager);
                dashboard_horizontal_recycler.setAdapter(adapter);

                LinearSnapHelper snapHelper = new LinearSnapHelper();
                snapHelper.attachToRecyclerView(dashboard_horizontal_recycler);

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (layoutManager.findLastCompletelyVisibleItemPosition()<(adapter.getItemCount()-1)){
                            layoutManager.smoothScrollToPosition(dashboard_horizontal_recycler,new RecyclerView.State(),
                                    layoutManager.findLastCompletelyVisibleItemPosition()+1);
                        }
                        else if (layoutManager.findLastCompletelyVisibleItemPosition()==adapter.getItemCount()){
                            layoutManager.smoothScrollToPosition(dashboard_horizontal_recycler,new RecyclerView.State(),
                                    layoutManager.findLastCompletelyVisibleItemPosition()-adapter.getItemCount());
                        }

                    }
                },0,3000);//
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error = "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonArrayRequest1);
        /// Request for Dashboard Verticle Horizontal View

        return v;
    }
}
