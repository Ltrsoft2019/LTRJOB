package com.ltrsoft.ltrjob.SettingFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.ltrjob.R;
public class SettingFragment extends Fragment {
    public SettingFragment() {}
    public Switch notification;
    public TextView contact;
    public Spinner language;
    ArrayAdapter <String> adapter ;
    String [] list = {"English","Marathi","Hindi","Kannda","Telgu","Tamil"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);
        notification = view.findViewById(R.id.notification_switch);
        contact = view.findViewById(R.id.contact_tv);
        language = view.findViewById(R.id.language_spinner);
        adapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,list);
        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        language.setAdapter(adapter);


        notification.setOnCheckedChangeListener((compoundButton, b) ->
        {
            if (b) {
                Toast.makeText(getContext(), "checked", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getContext(), "unChecked", Toast.LENGTH_SHORT).show();
            }
        } );

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String applyurl = "https://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(applyurl)));
                startActivity(i);
            }
        });

        return view;
    }
}