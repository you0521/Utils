package com.example.administrator.jetsenstudy.u.utils;

import com.google.gson.Gson;

import java.util.List;

public class GsonUtils {

    private static Gson gson = new Gson();

    public static <T> T json2Bean(String result, Class<T> clz) {
        return gson.fromJson(result, clz);
    }

    public static String bean2Json(Object o) {
        return gson.toJson(o);
    }

    public static String list2Json(List list) {

        return gson.toJson(list);
    }
}
