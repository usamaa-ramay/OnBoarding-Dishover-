package com.example.e_commerce_app.data.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class Utiles {
    private static final String PREFERENCE = "MyPreference";

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
    }

    public static void saveBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = getPrefs(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = getPrefs(context);
        return sharedPreferences.getBoolean(key, value);
    }

    public static void saveString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = getPrefs(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = getPrefs(context);
        return sharedPreferences.getString(key, value);
    }

    public static void saveInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getPrefs(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences = getPrefs(context);
        return sharedPreferences.getInt(key, value);
    }

    public static <T> void saveObject(Context context, String key, T value) {
        SharedPreferences sharedPreferences = getPrefs(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        editor.putString(key, json);
        editor.apply();
    }

    public static <T> T getObject(Context context, String key, Class<T> value) {
        SharedPreferences sharedPreferences = getPrefs(context);
        String value1 = sharedPreferences.getString(key, null);
        Gson gson = new Gson();
        if (value1 != null) {
            return gson.fromJson(value1, value);
        } else {
            return null;
        }
    }


}
