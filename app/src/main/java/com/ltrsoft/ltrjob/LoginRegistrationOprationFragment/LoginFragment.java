package com.ltrsoft.ltrjob.LoginRegistrationOprationFragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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
import com.ltrsoft.ltrjob.DashboardFragment;
import com.ltrsoft.ltrjob.NavigationDrawerFragment;
import com.ltrsoft.ltrjob.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginFragment extends Fragment {
    public LoginFragment() {
    }

    private TextView forgot, createaccount, spinnertxt, document;
    private Button loginButton;
    private EditText loginEmail, loginPassword;
    private ProgressBar bar;
    Userclass userclass = new Userclass();
    private static final String BASE_URL = "https://job.ltr-soft.com/login1.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.loginfragment, container, false);

        loginEmail = v.findViewById(R.id.loginEmail);
        loginPassword = v.findViewById(R.id.loginPassword);
        loginButton = v.findViewById(R.id.loginButton);
        bar = v.findViewById(R.id.progressBar);
        forgot = v.findViewById(R.id.forgot);
        createaccount = v.findViewById(R.id.create_new_account);
        bar.setVisibility(View.GONE);

        //<----------------Login Button Code------------->//
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()) {
                    login(userclass.setUser_email(email), userclass.setUser_password(password));
                    loginButton.setVisibility(View.GONE);
                    bar.setVisibility(View.VISIBLE);

                } else {
                    loginEmail.setError("Please Enter Email");
                    loginPassword.setError("Please Enter Password");
                }

            }
        });

        //<--------------End of Login Button ---------------->//


        //<----------- New Registration -------------------->//
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrationFragment registrationFragment =new RegistrationFragment();
                getFragmentManager().beginTransaction().replace(R.id.constraint, registrationFragment).addToBackStack(null).commit();

            }

            //<----------- End of New Registration -------------------->//
        });

        //<--------------Forgot Password Text -------------->//
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Otpsend otpsend=new Otpsend();
                getFragmentManager().beginTransaction().replace(R.id.constraint, otpsend).addToBackStack(null).commit();

            }
        });

        //<--------------End of Forgot Password Text -------------->//

        return v;
    }

    private void login(String email, String password) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("data = " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String msg = jsonObject.getString("Message");
                    if (msg.equals("100")) {
                        Toast.makeText(getContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                        NavigationDrawerFragment navigationDrawerFragment = new NavigationDrawerFragment();
                        getFragmentManager().beginTransaction().replace(R.id.constraint, navigationDrawerFragment).commit();
                        bar.setVisibility(View.GONE);
                        loginButton.setVisibility(View.VISIBLE);
                        SharedPreferences pref = getActivity().getSharedPreferences("login", MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putBoolean("flag", true)
                                .apply();

//                        // Sending Fragment
                        JSONObject userData = jsonObject.getJSONObject("0");
                        String user_id = userData.getString("user_id");


                    } else if (msg.equals("200")) {
                        Toast.makeText(getContext(), "Invalid Password", Toast.LENGTH_LONG).show();
                        bar.setVisibility(View.GONE);
                        loginButton.setVisibility(View.VISIBLE);

                    } else {
                        Toast.makeText(getContext(), "Student Not Found Please Create New Account", Toast.LENGTH_LONG).show();
                        bar.setVisibility(View.GONE);
                        loginButton.setVisibility(View.VISIBLE);

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
                map.put("email", userclass.setUser_smobile(email));
                map.put("password", userclass.setUser_password(password));
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(stringRequest);

    }
}
