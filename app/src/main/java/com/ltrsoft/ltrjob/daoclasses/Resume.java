package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

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
import com.ltrsoft.ltrjob.pojoclass.Patent;
import com.ltrsoft.ltrjob.pojoclass.Qualification;
import com.ltrsoft.ltrjob.pojoclass.Research_Paper;
import com.ltrsoft.ltrjob.pojoclass.Technical_Skill;
import com.ltrsoft.ltrjob.pojoclass.Userclass;
import com.ltrsoft.ltrjob.pojoclass.Workshop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Resume {
    Object []objects=new Object[5];
    ArrayList<Award>awards=new ArrayList<>();
    ArrayList<Qualification> qualification=new ArrayList<Qualification>();
    ArrayList<Certification>certifications=new ArrayList<>();
    ArrayList<Research_Paper>researchPapers=new ArrayList<>();
    ArrayList<Patent>patents = new ArrayList<>();
    ArrayList<Workshop>workshops = new ArrayList<>();
    String  USER_PROFILE_READ_URL2="https://job.ltr-soft.com/resume2.php";
   String  USER_PROFILE_READ_URL="https://job.ltr-soft.com/resume_query.php";
    public void getall(Context context, UserCallBack userCallBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, USER_PROFILE_READ_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response"+response);
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

                            Toast.makeText(context, ""+user_fname.toString(), Toast.LENGTH_SHORT).show();

                                Userclass user = new Userclass(user_id,user_fname,user_mname,user_lname,user_email,user_smobile
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


//                                Toast.makeText(context, ""+award_name.toString(), Toast.LENGTH_SHORT).show();

                                awards.add(award);
                                objects[1] = awards;
                            }

                            JSONArray jsonArray2 = jsonObject.getJSONArray("certifications");
                            for (int i = 0; i <jsonArray2.length() ; i++) {
                                JSONObject jsonObject1 = jsonArray2.getJSONObject(i);
                                String certification_id = jsonObject1.getString("certification_id");
                                String certification_title = jsonObject1.getString("certification_title");
                                Certification certification = new Certification(certification_id,certification_title,
                                        "","","");
                                    certifications.add(certification);
                                objects[2] = certifications;
                            }

                            JSONArray jsonArray3 = jsonObject.getJSONArray("patents");
                            for (int i = 0; i <jsonArray3.length() ; i++) {
                                JSONObject jsonObject1 = jsonArray3.getJSONObject(i);
                                String patent_id = jsonObject1.getString("patent_id");
                                String patent_name = jsonObject1.getString("patent_name");
                                String patent_number = jsonObject1.getString("patent_number");

                                Patent patent = new Patent(patent_id,"","","","",
                                        "",patent_number,patent_name,"","");
                                patents.add(patent);
                                objects[3] = patents;
                            }

                            JSONArray jsonArray4 = jsonObject.getJSONArray("research_paper");
                            for (int i = 0; i <jsonArray4.length() ; i++) {
                                JSONObject jsonObject1 = jsonArray4.getJSONObject(i);
                                String research_citation = jsonObject1.getString("research_citation");
                                String research_topic_name = jsonObject1.getString("research_topic_name");
                                String research_paper_id = jsonObject1.getString("research_paper_id");
//
                                Research_Paper researchPaper=new Research_Paper(research_topic_name,research_citation,"");
//                                Research_Paper researchPaper = new Research_Paper("","","","","",research_topic_name,
//                                        research_citation,"","","","","","",
//                                        "","","","","","","","","");
                                researchPapers.add(researchPaper);
                                objects[4] = researchPapers;
                            }

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

    public void getall2(Context context, RecyclerView research_paper_recycler, UserCallBack userCallBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, USER_PROFILE_READ_URL2,
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

                            Toast.makeText(context, ""+user_fname.toString(), Toast.LENGTH_SHORT).show();

                            Userclass user = new Userclass(user_id,user_fname,user_mname,user_lname,user_email,user_smobile
                                    ,"",user_gender,"",user_photo,user_address,city_name,district_name,state_name
                                    ,country_name,user_collegename,"","",user_linkedin_id,user_github_id,"","" ,
                                    user_carier_objective);

                            objects[0]=user;

//                                     Extract workshop information
                                    JSONArray workshopArray = jsonObject.getJSONArray("workshop");
                                    ArrayList<Workshop> workshops = new ArrayList<>();
                                    for (int i = 0; i < workshopArray.length(); i++) {
                                        JSONObject workshopObj = workshopArray.getJSONObject(i);
                                        String workshop_id = workshopObj.getString("workshop_id");
                                        String workshop_venue = workshopObj.getString("workshop_venue");
                                        String workshop_name = workshopObj.getString("workshop_name");
                                    Workshop workshop = new Workshop("",workshop_id,"","",workshop_name,workshop_venue,"",
                                            "");
                                        workshops.add(workshop);
                                        objects[1]=workshops;

                                    }

                            JSONArray skillArray = jsonObject.getJSONArray("technical");
                            ArrayList<Technical_Skill> skills= new ArrayList<>();
                            for (int i = 0; i < skillArray.length(); i++) {
                                JSONObject skillobj = skillArray.getJSONObject(i);
                                String technical_skill_name = skillobj.getString("technical_skill_name");
                                String technical_skill_id = skillobj.getString("technical_skill_id");
                                Technical_Skill technicalSkill = new Technical_Skill("",technical_skill_id,"",technical_skill_name);
                                skills.add(technicalSkill);
                                objects[2]=skills;
                            }

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

