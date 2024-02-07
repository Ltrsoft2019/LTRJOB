//package com.ltrsoft.ltrjob;
//
//import static java.lang.Thread.sleep;
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//
//import com.ltrsoft.ltrjob.daoclasses.Login;
//
//public class spashscreen extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_spashscreen);
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    sleep(4000);
//                    Login login=new Login();
//                    getFragmentManager().beginTransaction().replace(R.id.maincontainer,login)
//                            .addToBackStack(null ).commit();
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t.start();
//    }
//}
