package com.sky.freereading.injection.component;

import android.app.Application;
import android.content.Context;

import com.sky.freereading.data.DataManager;
import com.sky.freereading.data.local.DatabaseHelper;
import com.sky.freereading.data.local.PreferencesHelper;
import com.sky.freereading.injection.ApplicationContext;
import com.sky.freereading.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tonycheng on 2017/5/10.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();

    PreferencesHelper preferenceHelper();

    DatabaseHelper databaseHelper();

    DataManager dataManager();
}
