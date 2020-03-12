package com.xinly.update;

import android.content.Context;
import android.util.Log;

public class UpdateChecker {

    public static void checkForDialog(Context context, String data) {
        if (context != null) {
            new CheckUpdateTask(context, Constants.TYPE_DIALOG, true, data).execute();
        } else {
            Log.e(Constants.TAG, "The arg context is null");
        }
    }


    public static void checkForNotification(Context context, String data) {
        if (context != null) {
            new CheckUpdateTask(context, Constants.TYPE_NOTIFICATION, false, data).execute();
        } else {
            Log.e(Constants.TAG, "The arg context is null");
        }

    }


}
