package com.sky.freereading.data.local;

import android.database.sqlite.SQLiteDatabase;

import com.sky.freereading.data.model.Category;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;
import rx.schedulers.Schedulers;

/**
 * Created by tonycheng on 2017/5/10.
 */
@Singleton
public class DatabaseHelper {

    private final BriteDatabase mDb;

    @Inject
    public DatabaseHelper(DbOpenHelper openHelper) {
        SqlBrite.Builder builder = new SqlBrite.Builder();
        mDb = builder.build().wrapDatabaseHelper(openHelper, Schedulers.immediate());
    }

    public BriteDatabase getDb() {
        return mDb;
    }

    public Flowable<Category> setCategory(final Collection<Category> categories) {
        return Flowable.create(new FlowableOnSubscribe<Category>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<Category> e) throws Exception {
                if (e.isCancelled()) return;
                BriteDatabase.Transaction transaction = mDb.newTransaction();
                try {
                    mDb.delete(Db.CategoryTable.TABLE_NAME, null);
                    for (Category category : categories) {
                        final long result = mDb.insert(Db.CategoryTable.TABLE_NAME,
                                Db.CategoryTable.toContentValues(category),
                                SQLiteDatabase.CONFLICT_REPLACE);
                        if (result > 0) e.onNext(category);
                    }
                    transaction.markSuccessful();
                    e.onComplete();
                } finally {
                    transaction.end();
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

    //由于目前 sqlbrite 还不支持 rxjava2 ，需要引入一个支持库
    public Flowable<List<Category>> getCategories() {
//        return mDb.createQuery(Db.CategoryTable.TABLE_NAME,
//                "SELECT * FROM " + Db.CategoryTable.TABLE_NAME)
//                .mapToList(new Func1<Cursor, Category>() {
//                    @Override
//                    public Category call(Cursor cursor) {
//                        return Db.CategoryTable.parseContentValues(cursor);
//                    }
//                });
        return null;
    }
}
