package com.sky.freereading.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import android.os.Parcelable;

/**
 * Created by tonycheng on 2017/5/10.
 */
@AutoValue
public abstract class FreeReadingEntity implements Parcelable {

    public abstract String avatar();

    public abstract String author();

    public abstract String publishAt();

    public abstract String desc();

    public abstract String url();

    public abstract String nextPage();

    public static TypeAdapter<FreeReadingEntity> typeAdapter(Gson gson) {
        return new AutoValue_FreeReadingEntity.GsonTypeAdapter(gson);
    }

    public static FreeReadingEntity create(String avatar, String author, String publishAt, String desc, String url, String nextPage) {
        return builder()
                .avatar(avatar)
                .author(author)
                .publishAt(publishAt)
                .desc(desc)
                .url(url)
                .nextPage(nextPage)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_FreeReadingEntity.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder avatar(String avatar);

        public abstract Builder author(String author);

        public abstract Builder publishAt(String publishAt);

        public abstract Builder desc(String desc);

        public abstract Builder url(String url);

        public abstract Builder nextPage(String nextPage);

        public abstract FreeReadingEntity build();
    }
}
