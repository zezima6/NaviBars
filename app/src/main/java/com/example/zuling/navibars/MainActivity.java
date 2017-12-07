package com.example.zuling.navibars;

import android.notifications.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    NotificationService NS = new NotificationService();
    String text = NS.getText();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*public char leftRight() {
        if (text.equals("Turn right")){
            Log.d("NotificationApp", rightturn);
            return '1';
        }
        else if (text.equals("Turn left")) {
            Log.d("NotificationApp", leftturn);
            return '2';
        }
        else if (text.equals("Drive nor")){
            Log.d("NotificationApp", gostraight);
            return '3';
        }
        else
            return '0';
    }*/


}
