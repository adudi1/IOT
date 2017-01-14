

package com.ibm.mobileappbuilder.osp20161213194459;

import android.app.Application;
import ibmmobileappbuilder.injectors.ApplicationInjector;
import android.support.multidex.MultiDexApplication;
import ibmmobileappbuilder.analytics.injector.AnalyticsReporterInjector;
import ibmmobileappbuilder.cloudant.factory.CloudantDatabaseSyncerFactory;
import java.net.URI;


/**
 * You can use this as a global place to keep application-level resources
 * such as singletons, services, etc.
 */
public class MyApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationInjector.setApplicationContext(this);
        AnalyticsReporterInjector.analyticsReporter(this).init(this);
        //Syncing cloudant ds
        CloudantDatabaseSyncerFactory.instanceFor(
            "weightdata",
            URI.create("https://7ab7eba0-15f4-4569-85c5-39a1568e1d7e-bluemix.cloudant.com/weightdata/")
        ).sync(null);
      }
}
