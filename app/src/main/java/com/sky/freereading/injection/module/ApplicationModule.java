package com.sky.freereading.injection.module;

import android.app.Application;
import android.content.Context;

import com.sky.freereading.injection.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tonycheng on 2017/5/10.
 */

/**
 * Provide application-level dependencies.
 */
@Module
public class ApplicationModule {

    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }
}
