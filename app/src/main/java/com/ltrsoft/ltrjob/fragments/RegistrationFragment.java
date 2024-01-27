package com.ltrsoft.ltrjob.fragments;

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

import com.ltrsoft.ltrjob.daoclasses.User_Deo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.User;
import com.ltrsoft.ltrjob.pojoclass.Userclass;
import com.ltrsoft.ltrjob.R;

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

                User user = new User(10,10,createfname.getText().toString(),createlmname.getText().toString(),createlmname.getText().toString(),createfname.getText().toString()
                ,createfname.getText().toString(),"","","","","",""
                ,"","","","","","","","","",""
                ,"","");

                User_Deo userDeo = new User_Deo();

                userDeo.createUser(user, getContext(), new UserCallBack() {
                    @Override
                    public void userSuccess(Object object) {
                        String  success= (String) object;
                        Toast.makeText(getContext(), "result"+success, Toast.LENGTH_SHORT).show();



                    }

                    @Override
                    public void userError(String error) {
                        Toast.makeText(getContext(), "error"+error.toString(), Toast.LENGTH_SHORT).show();
                    }


                });


//
            }
        });
        return v;
    }
}
