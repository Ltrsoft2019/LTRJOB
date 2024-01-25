package com.ltrsoft.ltrjob.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.Classes.Userclass;
import com.ltrsoft.ltrjob.DEOCLasses.Registration;
import com.ltrsoft.ltrjob.R;

import java.util.HashMap;
import java.util.Map;

public class RegistrationFragment extends Fragment {
    public RegistrationFragment(){}
    private Button register;
    private TextView sign;
    private EditText createfname,createlmname,createemail,usermobile, password1,conform_password1;

    Userclass userclass=new Userclass();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.registrationfragment, container, false);
        createfname = v.findViewById(R.id.createfname);
        createfname = v.findViewById(R.id.createfname);
        createlmname = v.findViewById(R.id.createlmname);
        createemail = v.findViewById(R.id.createemail);
        usermobile = v.findViewById(R.id.usermobile);
        password1 = v.findViewById(R.id.password1);
        conform_password1 = v.findViewById(R.id.conform_password1);
        register = v.findViewById(R.id.register);
        sign = v.findViewById(R.id.sign);

        //<---------Registration Button ------>//
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Registration registration = new Registration(requireContext(), getFragmentManager(), createfname, createlmname, createemail, usermobile, password1, conform_password1);
                registration.userRegistration();



//                if(createfname.getText().toString().trim().isEmpty())
//                {
//                    createfname.setError("Enter First Name");
//                }
//                else {
//                    createfname.setError(null);
//
//
//                        if(createlmname.getText().toString().trim().isEmpty())
//                        {
//                            createlmname.setError("Enter last Name");
//
//                        }
//                        else {
//                            createlmname.setError(null);
//                            if(createemail.getText().toString().trim().isEmpty())
//                            {
//                                createemail.setError("Enter last Name");
//
//                            }
//                            else {
//                                createemail.setError(null);
//                                if(usermobile.getText().toString().trim().isEmpty())
//                                {
//                                    usermobile.setError("Enter last Name");
//
//                                }
//                                else {
//                                    usermobile.setError(null);
//                                    if(password1.getText().toString().trim().isEmpty())
//                                    {
//                                        password1.setError("Enter last Name");
//
//                                    }
//                                    else {
//                                        password1.setError(null);
//                                        if(conform_password1.getText().toString().trim().isEmpty())
//                                        {
//                                            conform_password1.setError("Enter last Name");
//
//                                        }
//                                        else {
//                                            conform_password1.setError(null);
//                                            String mobileno=usermobile.getText().toString();
//                                            if(mobileno.length()==10) {
//
//
//                                                String pass = password1.getText().toString();
//                                                String confrom = conform_password1.getText().toString();
//                                                if (pass.length() > 7) {
//                                                    if (pass.equals(confrom)) {
//
//                                                        senddata();
//
//                                                    } else {
//                                                        Toast.makeText(getContext(), "Password Do do not Match Please Try again", Toast.LENGTH_SHORT).show();
//                                                        password1.setText("");
//                                                        conform_password1.setText("");
//
//                                                    }
//                                                } else {
//                                                    Toast.makeText(getContext(), "password should be minimum of 8" +
//                                                            " characters", Toast.LENGTH_SHORT).show();
//                                                }
//                                            }
//                                            else {
//                                                Toast.makeText(getContext(), "Please Enter valid phone number ", Toast.LENGTH_SHORT).show();
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//        });
//
//        //<---------------------End of Registraion button ----------------->//
//
//                //<--------Sign In Button ------>//
//        sign.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LoginFragment loginFragment=new LoginFragment();
//                getFragmentManager().beginTransaction().replace(R.id.constraint, loginFragment)
//                        .commit();
//            }
//        });
//        //<-------- End of Sign In Button ------>//
//
//
//
//
//
//        return v;
//    }
//
////    public void senddata(){
////        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
////        StringRequest stringRequest =new StringRequest(Request.Method.POST,
////                BASE_URL, new Response.Listener<String>() {
////            @Override
////            public void onResponse(String response) {
////                Toast.makeText(getContext(), "Registration Successfully", Toast.LENGTH_LONG).show();
////                createfname.setText("");
////                createlmname.setText("");
////                createemail.setText("");
////                usermobile.setText("");
////                password1.setText("");
////                conform_password1.setText("");
////                LoginFragment loginFragment=new LoginFragment();
////                getFragmentManager().beginTransaction().replace(R.id.constraint, loginFragment).addToBackStack(null).commit();
////
////            }
////        }, new Response.ErrorListener() {
////            @Override
////            public void onErrorResponse(VolleyError error) {
////                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
////            }
////        }) {
////            @Nullable
////            @Override
////            protected Map<String, String> getParams() throws AuthFailureError {
////                HashMap<String,String> map=new HashMap<>();
////                map.put("fname",userclass.setUser_fname(createfname.getText().toString()));
////                map.put("lname",userclass.setUser_lname(createlmname.getText().toString()));
////                map.put("sm",userclass.setUser_smobile(usermobile.getText().toString()));
////                map.put("email",userclass.setUser_email(createemail.getText().toString()));
////                map.put("pass",userclass.setUser_password(password1.getText().toString()));
////                return map;
////            }
////        };
////        requestQueue.add(stringRequest);
////    }
            }
        });
        return v;
    }
}
