package com.example.chaitanya.activitylifecycle.util;

import android.os.Handler;
import android.widget.TextView;
import java.util.List;

public class Utils {

    private static StatusTracker mStatusTracker = StatusTracker.getInstance();

    public static void printStatus(final TextView viewMethods, final TextView viewStatus) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            //get the stack of activity lifecycle methods called and print to textview
            public void run() {
               StringBuilder sbMethods = new StringBuilder();
                List<String> listMethods = mStatusTracker.getMethodList();
                for (String method : listMethods) {
                    sbMethods.insert(0, method + "\r\n");
                }
                if (viewMethods != null) {
                    viewMethods.setText(sbMethods.toString());
                }

                //get the status of all activity classes and print textview
                StringBuilder sbStatus = new StringBuilder();
                for (String key : mStatusTracker.keySet()) {
                    sbStatus.insert(0, key + ": " + mStatusTracker.getStatus(key) + "\n");
                }
                if (viewStatus != null) {
                    viewStatus.setText(sbStatus.toString());
                }
            }
        }, 750);
    }
}