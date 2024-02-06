package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Award;
import com.ltrsoft.ltrjob.pojoclass.Certification;
import com.ltrsoft.ltrjob.pojoclass.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Resume {
    Object []objects=new Object[3];
    ArrayList<Award>awards=new ArrayList<>();
    ArrayList<Certification>certifications=new ArrayList<>();
//    ArrayList<Award>awards=new ArrayList<>();
//    ArrayList<Award>awards=new ArrayList<>();
//    ArrayList<Award>awards=new ArrayList<>();
   String  USER_PROFILE_READ_URL="https://job.ltr-soft.com/resume_query.php";
    public void getall(Context context, UserCallBack userCallBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, USER_PROFILE_READ_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String user_id = jsonObject.getString("user_id");
                            String user_fname = jsonObject.getString("user_fname");
                            String user_mname = jsonObject.getString("user_mname");
                            String user_lname = jsonObject.getString("user_lname");
                            String user_email = jsonObject.getString("user_email");
                            String user_smobile = jsonObject.getString("user_smobile");
                            String user_gender = jsonObject.getString("user_gender");
                            String user_photo = jsonObject.getString("user_photo");
                            String user_address = jsonObject.getString("user_address");
                            String city_name = jsonObject.getString("city_name");
                            String district_name = jsonObject.getString("district_name");
                            String state_name = jsonObject.getString("state_name");
                            String country_name = jsonObject.getString("country_name");
                            String user_collegename = jsonObject.getString("user_collegename");
                            String user_linkedin_id = jsonObject.getString("user_linkedin_id");
                            String user_github_id = jsonObject.getString("user_github_id");
                            String user_carier_objective = jsonObject.getString("user_carier_objective");

                                User user = new User(user_id,user_fname,user_mname,user_lname,user_email,user_smobile
                                ,"",user_gender,"",user_photo,user_address,city_name,district_name,state_name
                                ,country_name,user_collegename,"","",user_linkedin_id,user_github_id,"","" ,
                                        user_carier_objective);

                                objects[0]=user;

                            JSONArray jsonArray = jsonObject.getJSONArray("awards");
                            for (int i = 0; i <jsonArray.length() ; i++) {
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                String award_id = jsonObject1.getString("award_id");
                                String award_name = jsonObject1.getString("award_name");
                                String award_given_by = jsonObject1.getString("award_given_by");
                                String award_category_name = jsonObject1.getString("award_category_name");
                                Award award = new Award(award_name,award_given_by,award_id,award_category_name);
                                awards.add(award);
                                objects[1] = awards;
                            }

                            JSONArray jsonArray2 = jsonObject.getJSONArray("certifications");
                            for (int i = 0; i <jsonArray2.length() ; i++) {
                                JSONObject jsonObject1 = jsonArray2.getJSONObject(i);
                                String certification_id = jsonObject1.getString("certification_id");
                                String certification_title = jsonObject1.getString("certification_title");
                                Certification certification = new Certification(certification_id,certification_title,"","","");
                                    certifications.add(certification);
                                objects[2] = certifications;
                            }


                            //Parse other JSONARRAY here and enter it in  like this

                        } catch (JSONException e) {
                            // Handle JSON parsing error
                            userCallBack.userError(e.toString());
                        }
                        userCallBack.userSuccess(objects);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                userCallBack.userError(error.toString());
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("user_id", "user-17");
                return hashMap;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}

