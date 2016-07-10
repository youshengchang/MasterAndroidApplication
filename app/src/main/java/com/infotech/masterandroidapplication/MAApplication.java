package com.infotech.masterandroidapplication;

import android.app.Application;

import com.infotech.masterandroidapplication.data.JobOffer;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by youshengchang on 7/9/16.
 */
public class MAApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.


        ParseObject.registerSubclass(JobOffer.class);

        Parse.initialize(this, "gZYZHR9m5fE8cTzFhh9xL6ItvBXSiIHPCvWXFbYS", "L0a2Ur4D59Kq0LpmbHhJnFLKmLTA6QcJYrZhjHt7");
    }
}
