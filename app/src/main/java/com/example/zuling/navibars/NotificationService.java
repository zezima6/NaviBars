package com.example.zuling.navibars;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Notification;
import android.content.Context;
import android.os.Parcelable;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

/**
 * Created by Zuling on 12/4/2017.
 */

public class NotificationService extends AccessibilityService {

    Context context;
    String text = "";
    String rightturn = "1";
    String leftturn = "2";
    String gostraight = "3";
    int turn = leftRight();

    @Override

    public void onCreate() {

        super.onCreate();
        ;
        context = getApplicationContext();
    }

    public String getText() {
        return text;
    }

    @Override
    protected void onServiceConnected() {
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.eventTypes = AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED;
        accessibilityServiceInfo.feedbackType = AccessibilityServiceInfo.FEEDBACK_ALL_MASK;
        accessibilityServiceInfo.notificationTimeout = 100;
        setServiceInfo(accessibilityServiceInfo);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {

        if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED) {
            Parcelable notifData = accessibilityEvent.getParcelableData();
            if (notifData instanceof Notification) {
                Notification data = (Notification) notifData;
                String dataText = data.extras.getCharSequence(Notification.EXTRA_TEXT).toString();
                Log.d("NotificationApp", dataText);
                if (dataText.length() >= 9) {
                    text = dataText.substring(0,9);
                    Log.d("NotificationApp", text);
                    leftRight();
                }
            }
        }
    }

    public char leftRight() {
        if (text.equals("Turn righ")){
            Log.d("NotificationApp", rightturn);
            return '1';
        }
        else if (text.equals("Turn left")) {
            Log.d("NotificationApp", leftturn);
            return '2';
        }
        else if (text.equals("Bike nort")){
            Log.d("NotificationApp", gostraight);
            return '3';
        }
        else
            return '0';
    }

    @Override
    public void onInterrupt() {

    }
}







