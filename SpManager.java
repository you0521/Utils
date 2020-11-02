package com.example.administrator.jetsenstudy.u.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/12/10.
 * 简单参数存储, 封装SharedPreferences
 */
public class SpManager {

    public static final String PREFERENCES_NAME = "jclasscard_android_global_config";

    private static SpManager instance;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SpManager(Context context) {

        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_MULTI_PROCESS);
        editor = preferences.edit();
    }

    public synchronized static void init(Context context) {
        if (instance == null) {
            instance = new SpManager(context);
        }
    }

    public static SpManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException("sharePreferences manager must be init");
        }
        return instance;
    }

    public String get(String key) {
        return get(key, "");
    }

    public boolean getBool(String key) {
        return get(key, false);
    }

    public int getInt(String key) {
        return get(key, -1);
    }

    public long getLong(String key) {
        return get(key, -1L);
    }

    public String get(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    public boolean get(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    public int get(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    public long get(String key, long defValue) {
        return preferences.getLong(key, defValue);
    }

    public void set(String key, String value) {
        editor.putString(key, value).apply();
    }

    public void set(String key, int value) {
        editor.putInt(key, value).apply();
    }

    public void set(String key, long value) {
        editor.putLong(key, value).apply();
    }

    public void set(String key, boolean value) {
        editor.putBoolean(key, value).apply();
    }
}
