package com.ayushhgoyal.acrasample;

import android.app.Application;

import org.acra.ACRA;
import org.acra.annotation.ReportsCrashes;

/**
 * Created by ayushhgoyal on 22/3/15.
 */
@ReportsCrashes(formKey = "", // will not be used
        formUri = "http://mandrillapp.com/api/1.0/messages/send.json"
)

public class MyApp extends Application {
    private ReportsCrashes mReportsCrashes;

    @Override
    public void onCreate() {
        super.onCreate();

        ACRA.init(this);

        mReportsCrashes = this.getClass().getAnnotation(ReportsCrashes.class);
        JsonSender jsonSender = new JsonSender(mReportsCrashes.formUri(), null);
        ACRA.getErrorReporter().setReportSender(jsonSender);

    }
}
