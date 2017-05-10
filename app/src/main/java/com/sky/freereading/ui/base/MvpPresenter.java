package com.sky.freereading.ui.base;

/**
 * Created by tonycheng on 2017/5/10.
 */

public interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
