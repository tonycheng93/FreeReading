package com.sky.freereading.injection.component;

/**
 * Created by tonycheng on 2017/5/10.
 */

import com.sky.freereading.injection.ConfigPersistent;
import com.sky.freereading.injection.module.ActivityModule;

import dagger.Component;

/**
 * A dagger component that will live during the lifecycle of an Activity but it won't be destroy
 * during configuration changes. Check {@link com.sky.freereading.ui.base.BaseActivity} to see how
 * this components survives configuration changes. Use the {@link com.sky.freereading.injection.ConfigPersistent}
 * scope to annotate dependencies that need to survive configuration changes (for example
 * Presenters).
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);
}
