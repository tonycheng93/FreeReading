package com.sky.freereading.data.local;

import android.content.ContentValues;
import android.database.Cursor;

import com.sky.freereading.data.model.Category;

/**
 * Created by tonycheng on 2017/5/10.
 */

public class Db {

    public Db() {
    }

    public abstract static class ArticleTable {

        public static final String TABLE_NAME = "Table_Article";

        public static final String CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +

                        ");";


    }

    public abstract static class CategoryTable {

        public static final String TABLE_NAME = "Table_CategoryName";

        public static final String COLUMN_CATEGORY_NAME = "category_name";

        public static final String COLUMN_CATEGORY_URL = "category_url";

        public static final String CREATE =
                "CREATE TABLE " + CategoryTable.TABLE_NAME + " (" +
                        COLUMN_CATEGORY_NAME + " TEXT NOT NULL, " +
                        COLUMN_CATEGORY_URL + " TEXT PRIMARY KEY" +
                        "); ";

        public static ContentValues toContentValues(Category category) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CATEGORY_NAME, category.name());
            values.put(COLUMN_CATEGORY_URL, category.url());
            return values;
        }

        public static Category parseContentValues(Cursor cursor) {
            return Category.builder()
                    .name(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CATEGORY_NAME)))
                    .url(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CATEGORY_URL)))
                    .build();
        }
    }
}
