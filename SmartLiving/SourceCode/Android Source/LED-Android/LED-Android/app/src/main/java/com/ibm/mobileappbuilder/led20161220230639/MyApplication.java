

package com.ibm.mobileappbuilder.led20161220230639;

import android.app.Application;
import ibmmobileappbuilder.injectors.ApplicationInjector;
import android.support.multidex.MultiDexApplication;


/**
 * You can use this as a global place to keep application-level resources
 * such as singletons, services, etc.
 */
public class MyApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationInjector.setApplicationContext(this);
    }
}
