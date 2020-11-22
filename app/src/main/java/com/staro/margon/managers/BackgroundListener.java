package com.staro.margon.managers;

import android.util.Log;

import com.staro.margon.utils.chat.ChatHelper;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class BackgroundListener implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onBackground() {
        ChatHelper.getInstance().destroy();
        Log.d("BackgroundListener", "Background Successful");
    }
}