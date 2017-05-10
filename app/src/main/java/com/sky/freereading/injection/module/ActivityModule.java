package com.sky.freereading.injection.module;

import android.app.Activity;
import android.content.Context;

import com.sky.freereading.injection.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tonycheng on 2017/5/10.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }
}
