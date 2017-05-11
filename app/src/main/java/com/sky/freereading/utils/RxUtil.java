package com.sky.freereading.utils;

import io.reactivex.disposables.Disposable;

/**
 * Created by tonycheng on 2017/5/11.
 */

public class RxUtil {

    private static void unsubscribe(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
