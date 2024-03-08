package com.ltrsoft.ltrjob.fragments;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;


import com.ltrsoft.ltrjob.R;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public class SettingFragment extends Fragment {
    public SettingFragment() {
    }

    private Switch notification_switch;
    LinearLayout layout;
    private TextView contact_tv;
    private String filelang = "language.txt";
    String lang;
    String translatedText, translatedText1;
    private static final int NOTIFICATION_ID = 1;
    private ImageView back;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting, container, false);
        back=view.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationDrawerFragment navigationDrawerFragment = new NavigationDrawerFragment();
                getFragmentManager().beginTransaction().replace(R.id.constraint,navigationDrawerFragment).commit();
            }
        });
        loadlocale();
        notification_switch = view.findViewById(R.id.notification_switch);


        notification_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    // Enable notifications
                    showRandomNotification();
                } else {
                    // Disable notifications
                }
            }

            private void showRandomNotification() {
                String[] notificationMessages = {
                        "Hello there!",
                        "How are you today?",
                        "Don't forget to check the app!",
                        "A new update is available!",
                        "Have a great day!"
                };

                // Select a random message from the array
                String randomMessage = notificationMessages[new Random().nextInt(notificationMessages.length)];

                // Create a notification
                NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "channel_id")
                        .setSmallIcon(R.drawable.home)
                        .setContentTitle("Random Notification")
                        .setContentText(randomMessage)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                // Get the NotificationManager system service
                NotificationManager notificationManager = (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);

                // Check if the SDK version is Oreo or higher and create a notification channel
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("channel_id", "Channel Name", NotificationManager.IMPORTANCE_DEFAULT);
                    notificationManager.createNotificationChannel(channel);
                }

                // Notify with the unique ID for the notification
                notificationManager.notify(NOTIFICATION_ID, builder.build());
            }




        });

        contact_tv = view.findViewById(R.id.contact_tv);
        layout = view.findViewById(R.id.language_card);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showlanguage();
            }
        });

        return view;
    }

    //    language
    private void showlanguage() {

        final String[] list = {"Assamee", "Bengali", "hindi", "kannada", "Marathi", "tamil", "telgu", "Urdu", "English"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Choose Language...");


        builder.setSingleChoiceItems(list, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setLocal("as");
                    lang = "as";
                    getActivity().recreate();
                } else if (i == 1) {
                    setLocal("bn");
                    lang = "bn";
                    getActivity().recreate();
                } else if (i == 2) {
                    setLocal("hi");
                    lang = "hi";
                    getActivity().recreate();
                } else if (i == 3) {
                    setLocal("kn");
                    lang = "kn";
                    getActivity().recreate();
                } else if (i == 4) {
                    setLocal("mr");
                    lang = "mr";
                    getActivity().recreate();
                } else if (i == 5) {
                    setLocal("ta");
                    lang = "ta";
                    getActivity().recreate();
                } else if (i == 6) {
                    setLocal("te");
                    lang = "te";
                    getActivity().recreate();
                } else if (i == 7) {
                    setLocal("ur");
                    lang = "ur";
                    getActivity().recreate();
                } else if (i == 8) {
                    setLocal("en");
                    lang = "en";
                    getActivity().recreate();
                }

                try {
                    FileOutputStream fos = getActivity().openFileOutput(filelang, Context.MODE_PRIVATE);
                    String data = lang;
                    fos.write(data.getBytes());
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                dialogInterface.dismiss();

            }
        });

        AlertDialog build = builder.create();
        build.show();
    }

    private void setLocal(String bhasa) {
        Locale local = new Locale(bhasa);
        Locale.setDefault(local);
        Configuration config = new Configuration();
        config.locale = local;
        getActivity().getBaseContext().getResources().updateConfiguration(config, getActivity().getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor edits = getActivity().getSharedPreferences("Setting", Context.MODE_PRIVATE).edit();
        edits.putString("my_lang", bhasa);
        edits.apply();
    }

    public void loadlocale() {
        SharedPreferences pref = getActivity().getSharedPreferences("Setting", Activity.MODE_PRIVATE);
        String language = pref.getString("my_lang", "");
        setLocal(language);
    }
}