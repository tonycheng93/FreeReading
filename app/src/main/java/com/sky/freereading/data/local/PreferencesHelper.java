package com.sky.freereading.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.sky.freereading.injection.ApplicationContext;

import javax.inject.Inject;

/**
 * Created by tonycheng on 2017/5/10.
 */

public class PreferencesHelper {

    public static final String PREF_FILE_NAME = "free_reading_pref_file";

    private final SharedPreferences mPref;

    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void clear() {
        mPref.edit().clear().apply();
    }
}
