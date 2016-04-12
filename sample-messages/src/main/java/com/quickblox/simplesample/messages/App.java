package com.quickblox.simplesample.messages;

import com.quickblox.sample.core.CoreApp;

public class App extends CoreApp {

    private static App instance;
    //TODO Don't use static variable for changeable behaviour, Use static only for util class.
    private static boolean activityVisible;

    private int currentUserId;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        super.initCredentials(Consts.QB_APP_ID, Consts.QB_AUTH_KEY, Consts.QB_AUTH_SECRET, Consts.QB_ACCOUNT_KEY);
    }

    public static synchronized App getInstance() {
        return instance;
    }

    public int getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(int currentUserId) {
        this.currentUserId = currentUserId;
    }

    public static boolean isMessagesActivityVisible() {
        return activityVisible;
    }

    //TODO Use ActivityLifecycleCallbacks to determine activity's state
    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }
}