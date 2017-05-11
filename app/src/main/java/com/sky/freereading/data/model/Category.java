package com.sky.freereading.data.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * 项目名称：FreeReading
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2017/5/10 20:25
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
@AutoValue
public abstract class Category implements Parcelable {

    public abstract String name();//文章分类标题

    public abstract String url();//文章分类地址

    public static TypeAdapter<Category> typeAdapter(Gson gson) {
        return new AutoValue_Category.GsonTypeAdapter(gson);
    }

    public static Category create(String name, String url) {
        return builder()
                .name(name)
                .url(url)
                .build();
    }


    public static Builder builder() {
        return new AutoValue_Category.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Builder url(String url);

        public abstract Category build();
    }
}
