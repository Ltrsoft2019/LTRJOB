package com.ltrsoft.ltrjob.LoginRegistrationOprationFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;

public class PasswordChangeFragment extends Fragment {
    public PasswordChangeFragment(){}
    private Button change;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.passwordchangefragment,container,false);
        change=v.findViewById(R.id.change);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment  loginFragment=new LoginFragment();
                getFragmentManager().beginTransaction().replace(R.id.constraint,loginFragment

                ).addToBackStack(null).commit();

            }
        });
        return v;
    }

}
