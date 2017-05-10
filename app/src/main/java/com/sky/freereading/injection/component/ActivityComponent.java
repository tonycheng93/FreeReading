package com.sky.freereading.injection.component;

/**
 * Created by tonycheng on 2017/5/10.
 */

import com.sky.freereading.MainActivity;
import com.sky.freereading.injection.PerActivity;
import com.sky.freereading.injection.module.ActivityModule;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
