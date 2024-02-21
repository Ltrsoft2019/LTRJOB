package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Qualification;
import com.ltrsoft.ltrjob.pojoclass.Qualification_Level;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class qualificationDeo {
    String fatchall="";
    String create="http://job.ltr-soft.com/Qualification/qulification_insert.php";
    String redid="   https://job.ltr-soft.com/Qualification/qualification_user_read.php";

    String update="https://job.ltr-soft.com/Qualification/qulification_update.php";
    String delete="";
    String qname,qyear,qcgpa;
    public  void create(Qualification qualification, Context context, String user_id,
                        UserCallBack userCallBack)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, create,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                            if (response.contains("success")) {
                                userCallBack.userSuccess("success");
                            } else {
                                userCallBack.userError(response.toString());
                            }
                        }
                        
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                userCallBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

               params.put("qualification_school_college" ,qualification.getQualification_school_college());
               params.put("qualification_passing_year",qualification.getQualification_passing_year());
               params.put("qualification_percentage_cgpa",qualification.getQualification_percentage_cgpa());

                params.put("user_id","user-17");
                params.put("qualification_level_id","qua_level-1");

              //  params.put("qualification_level_id",qualification.getQualification_id());

                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }





    public  void  fatchtqualification(final Context context , RecyclerView recyclerView, UserCallBack callBack) {
        final ArrayList<Qualification> qualificationArrayList = new ArrayList<>();

        StringRequest request = new StringRequest(Request.Method.POST, redid, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String qualification_level_id = jsonObject.getString("qualification_level_id");
                        String qualification_school_college =jsonObject.getString("qualification_school_college");
                        String qualification_passing_year=jsonObject.getString("qualification_passing_year");
                        String qualification_percentage_cgpa=jsonObject.getString("qualification_percentage_cgpa");

                        Toast.makeText(context, "choll name"+qualification_school_college.toString(), Toast.LENGTH_SHORT).show();

                        Qualification technicalSkill = new Qualification(qualification_school_college,qualification_passing_year,qualification_percentage_cgpa);

                        qualificationArrayList.add(technicalSkill);


                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(qualificationArrayList);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.userError(error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();


                hashMap.put("user_id","user-17");

                return hashMap;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }







    public void getall(final Context context , Qualification qualification, UserCallBack
            callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, fatchall, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String qualification_level_id = jsonObject.getString("qualification_level_id");
                        String qualification_school_college =jsonObject.getString("qualification_school_college");
                        String qualification_passing_year=jsonObject.getString("qualification_passing_year");
                        String qualification_percentage_cgpa=jsonObject.getString("qualification_percentage_cgpa");

                        Qualification qualification1 = new Qualification("","",qualification_level_id, qualification_school_college, qualification_passing_year, qualification_percentage_cgpa);


                        //  miniProject.add(miniProject1);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(qualification);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error: " + error, Toast.LENGTH_SHORT).show();
                callBack.userError(error.toString());
            }
        }){


        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }




    public void updatequlification(String cname, String passingy,String cgp,Context context, UserCallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, update,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("success")) {

                            callBack.userSuccess("success");
                            Toast.makeText(context, ""+response.toString(), Toast.LENGTH_SHORT).show();
                        } else {
                            callBack.userError(response.toString());
                            Toast.makeText(context, ""+response.toString(), Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.userError(error.toString());
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();

                hashMap.put("qualification_school_college" ,cname.toString());
                hashMap.put("qualification_passing_year",passingy.toString());
                hashMap.put("qualification_percentage_cgpa",cgp.toString());


                hashMap.put("user_id","user-17");
                hashMap.put("qualification_level_id","qua_level-1");
                hashMap.put("qualification_id","qua-19");


                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }





    public void deletequlification( Qualification qualification,String userid,String qualification_level_id,Context context,UserCallBack callBack){


        StringRequest stringRequest= new StringRequest(Request.Method.POST, delete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();


map.put("String qualification_level_id",qualification_level_id.toString());
map.put("user_id",userid);


                return map;
            }
        };

    }









    public  void createqulificationlevel(Qualification_Level qualificationLevel, UserCallBack callBack, Context context)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, create,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String msg = jsonObject.getString("Message");
                            if (msg.equals("100")) {
                                callBack.userSuccess(msg);

                            } else if (msg=="200") {
                                callBack.userError("created");

                            } else if (msg=="300") {
                                callBack.userError("created Failed");
                            }
                        } catch (JSONException e) {
                            callBack.userError(e.toString());
                            throw new RuntimeException(e);

                        }

//
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("qualification_level_name" ,qualificationLevel.getQualification_level_name());

                //  params.put("qualification_level_id",qualification.getQualification_id());

                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }























    public void fatchqulificationlevel( Qualification_Level  qualificationLevel,String qulificationlevelid,Context context) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, update,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                int   qualification_level_id= Integer.parseInt(jsonObject.getString("qualification_level_id"));
                                String qualification_level_name =jsonObject.getString("qualification_level_name");

                                Qualification_Level qualificationLevel1 = new Qualification_Level(qualification_level_id,qualification_level_name);


                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();

                hashMap.put("qualification_level_id",qulificationlevelid.toString());

                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }


    public void getallqulifion(final Context context ,Qualification_Level qualification, UserCallBack
            callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, fatchall, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        int   qualification_level_id= Integer.parseInt(jsonObject.getString("qualification_level_id"));
                        String qualification_level_name =jsonObject.getString("qualification_level_name");

                        Qualification_Level qualificationLevel1 = new Qualification_Level(qualification_level_id,qualification_level_name);

                        //  miniProject.add(miniProject1);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(qualification);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error: " + error, Toast.LENGTH_SHORT).show();
                callBack.userError(error.toString());
            }
        }){


        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }


    public void updatequlificationlevel(Qualification_Level qualificationLevel, String userid,String qualification_level_id, Context context, UserCallBack callBack){
        StringRequest stringRequest= new StringRequest(Request.Method.POST, update,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("success")) {

                            callBack.userSuccess("success");
                        } else {
                            callBack.userError(response.toString());
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap=new HashMap<>();

                hashMap.put("qualification_school_college" ,qualificationLevel.getQualification_level_name());

                hashMap.put("qualification_level_id",qualification_level_id.toString());


                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }



    public void deletequlificationlevel( Qualification_Level qualificationLevel,String userid,String qualification_level_id,Context context,UserCallBack callBack) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, delete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();


                map.put("String qualification_level_id", qualification_level_id.toString());
                map.put("user_id", userid);


                return map;
            }
        };




    }
}
