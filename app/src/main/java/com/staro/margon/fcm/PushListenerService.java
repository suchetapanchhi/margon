package com.staro.margon.fcm;

import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;
import com.quickblox.messages.services.fcm.QBFcmPushListenerService;
import com.staro.margon.App;
import com.staro.margon.R;
import com.staro.margon.ui.activity.SplashActivity;
import com.staro.margon.utils.ActivityLifecycle;
import com.staro.margon.utils.NotificationUtils;

import java.util.Map;

public class PushListenerService extends QBFcmPushListenerService {
    private static final String TAG = PushListenerService.class.getSimpleName();
    private static final int NOTIFICATION_ID = 1;

    protected void showNotification(String message) {
        NotificationUtils.showNotification(App.getInstance(), SplashActivity.class,
                App.getInstance().getString(R.string.notification_title), message,
                R.drawable.ic_logo_vector, NOTIFICATION_ID);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }

    @Override
    protected void sendPushMessage(Map data, String from, String message) {
        super.sendPushMessage(data, from, message);
        Log.v(TAG, "From: " + from);
        Log.v(TAG, "Message: " + message);
        if (ActivityLifecycle.getInstance().isBackground()) {
            showNotification(message);
        }
    }
}