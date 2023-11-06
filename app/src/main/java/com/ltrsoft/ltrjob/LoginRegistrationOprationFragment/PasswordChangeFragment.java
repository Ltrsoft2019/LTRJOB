package com.ltrsoft.ltrjob.LoginRegistrationOprationFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.ltrsoft.ltrjob.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PasswordChangeFragment extends Fragment {
    public PasswordChangeFragment(){}
    private EditText Com_Password,Password;
    private Button change;
    private static final String BASE_URL = "https://job.ltr-soft.com/User_Detail/update_password.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.passwordchangefragment,container,false);
        change=v.findViewById(R.id.change);
        Password=v.findViewById(R.id.Password);
        Com_Password=v.findViewById(R.id.Com_Password);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password1 = Password.getText().toString();
                String conform = Com_Password.getText().toString();


                if (password1.trim().isEmpty()) {
                    Password.setError("Please Enter Password");
                } else {
                    Password.setError(null);


                    if (conform.trim().isEmpty()) {
                        Com_Password.setError("Please Enter Conform Password");

                    } else {
                        Com_Password.setError(null);
                        if(password1.equals(conform))
                        {
                            if(password1.length() >7&& password1.length()<15 && conform.length()>7&& conform.length()<15 ) {
                                login(password1);
                            }
                            else {
                                Toast.makeText(getContext(), "Please Enter Passord Greater Than 8 less than 15", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getContext(), "Password & Conform Password are not Same Try Again", Toast.LENGTH_SHORT).show();
                            Password.setText("");
                            Com_Password.setText("");

                        }
                    }
                }


            }
        });
        return v;
    }
    private void login(String password) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("data = " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String msg = jsonObject.getString("Message");
                    if (msg.equals("100")) {
                        Toast.makeText(getContext(), "Password Updated Successfully", Toast.LENGTH_SHORT).show();



                    } else if (msg.equals("200")) {
                        Toast.makeText(getContext(), "Password Not Updated Try Again", Toast.LENGTH_LONG).show();


                    } else {
                        Toast.makeText(getContext(), "Mobile No Incorrect", Toast.LENGTH_LONG).show();


                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "error = " + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("mobile", "7057547014");
                map.put("password", String.valueOf(password));
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(stringRequest);

    }

}
