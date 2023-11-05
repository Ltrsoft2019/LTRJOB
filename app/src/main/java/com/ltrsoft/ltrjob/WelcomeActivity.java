package com.ltrsoft.ltrjob;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1000);

                    Intent main_activity_intent=new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(main_activity_intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}























//
//  if (mobileDataInfo != null && !mobileDataInfo.isConnected()) {
//          Toast.makeText(this, "Mobile data is turned off. Please enable mobile data or connect to Wi-Fi.", Toast.LENGTH_LONG).show();
//          showYesNoDialog();
////            Intent intent = new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
////            startActivity(intent);
//          }
//          else {
//
//
//          Thread thread = new Thread() {
//public void run() {
//        try {
//        sleep(3000);
//        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
//        finish();
//        } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//        }
//        }
//        };
//        thread.start();
//        }
//        }
//private void showYesNoDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("Your Internet Connection is Off Do you want to continue?");
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//public void onClick(DialogInterface dialog, int which) {
//        Intent intent = new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
//        startActivity(intent);
//
//        }
//        });
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//public void onClick(DialogInterface dialog, int which) {
//        // User clicked No, perform some other action or dismiss the dialog
//        dialog.dismiss();
//        }
//        });
//        builder.setCancelable(false); // Prevent the dialog from being canceled by tapping outside of it
//        builder.show();
//
//        }
//        }