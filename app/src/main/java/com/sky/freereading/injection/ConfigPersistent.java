package com.sky.freereading.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by tonycheng on 2017/5/10.
 */

/**
 * A scoping annotation to permit dependencies conform to the life of the
 * {@link }
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigPersistent {
}
