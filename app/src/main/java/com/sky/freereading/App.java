package com.sky.freereading;

import android.app.Application;
import android.content.Context;

import com.sky.freereading.injection.component.ApplicationComponent;
import com.sky.freereading.injection.component.DaggerApplicationComponent;
import com.sky.freereading.injection.module.ApplicationModule;

import timber.log.Timber;

/**
 * Created by tonycheng on 2017/5/10.
 */

public class App extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent != null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
