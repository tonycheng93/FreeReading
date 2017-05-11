package com.sky.freereading.data;

import com.sky.freereading.data.local.DatabaseHelper;
import com.sky.freereading.data.local.PreferencesHelper;
import com.sky.freereading.data.model.Category;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by tonycheng on 2017/5/10.
 */
@Singleton
public class DataManager {

    private final DatabaseHelper mDatabaseHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public DataManager(DatabaseHelper databaseHelper, PreferencesHelper preferencesHelper) {
        mDatabaseHelper = databaseHelper;
        mPreferencesHelper = preferencesHelper;
    }

    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }


    public Flowable<List<Category>> getCategories() {
        return mDatabaseHelper.getCategories().distinct();
    }
}
