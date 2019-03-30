package com.leenadam.app;

import android.app.Application;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class Aplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize the Firebase library with an Android context.
        Firebase.setAndroidContext(this);

        if (!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }

}