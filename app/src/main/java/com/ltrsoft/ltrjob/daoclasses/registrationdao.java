//package com.ltrsoft.ltrjob.daoclasses;
//
//import static com.ltrsoft.ltrjob.daoclasses.Login.BASE_URL;
//import static java.security.AccessController.getContext;
//
//import android.content.Context;
//import android.widget.Toast;
//
//import androidx.appcompat.app.WindowDecorActionBar;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//import com.ltrsoft.ltrjob.interfaces.UserCallBack;
//
//public class registrationdao {
//
//    public void registration(Context context, UserCallBack userCallBack)
//    {
//        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
//        StringRequest stringRequest =new StringRequest(Request.Method.POST,
//                BASE_URL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                Toast.makeText(getContext(), "Registration Successfully", Toast.LENGTH_LONG).show();
//                WindowDecorActionBar.TabImpl createfname;
//                createfname.setText("");
//
//
//    }
//}, new Response.ErrorListener() {
//@Override
//public void onErrorResponse(VolleyError error) {
//        Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
//        }
//        }) {
//@Nullable
//@Override
//protected Map<String, String> getParams() throws AuthFailureError {
//        HashMap<String,String> map=new HashMap<>();
//        map.put("fname",userclass.setUser_fname(createfname.getText().toString()));
//        map.put("lname",userclass.setUser_lname(createlmname.getText().toString()));
//        map.put("sm",userclass.setUser_smobile(usermobile.getText().toString()));
//        map.put("email",userclass.setUser_email(createemail.getText().toString()));
//        map.put("pass",userclass.setUser_password(password1.getText().toString()));
//        return map;
//        }
//        };
//        requestQueue.add(stringRequest);
//        }
//        }
//    }
//
//}
