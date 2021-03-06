package com.sky.freereading.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sky.freereading.injection.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by tonycheng on 2017/5/10.
 */
@Singleton
public class DbOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "free_reading.db";
    private static final int DATABASE_VERSION = 1;

    @Inject
    public DbOpenHelper(@ApplicationContext Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(Db.CategoryTable.CREATE);
            db.execSQL(Db.ArticleTable.CREATE);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
