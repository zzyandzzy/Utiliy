package xyz.zzyandzzy.utiliy.log;

import android.util.Log;

import io.reactivex.annotations.NonNull;

/**
 * Created by zzyandzzy on 2017/10/8.
 */

public class LogUtils {
    private static final String TAG = "LogUtils";

    public static void v(@NonNull String message) {
        Log.v(TAG, message);
    }

    public static void v(@NonNull String tag, @NonNull String message) {
        Log.v(tag, message);
    }

    public static void i(@NonNull String message) {
        Log.i(TAG, message);
    }

    public static void i(@NonNull String tag, @NonNull String message) {
        Log.i(tag, message);
    }

    public static void d(@NonNull String message) {
        Log.d(TAG, message);
    }

    public static void d(@NonNull String tag, @NonNull String message) {
        Log.d(tag, message);
    }

    public static void w(@NonNull String message) {
        Log.w(TAG, message);
    }

    public static void w(@NonNull String tag, @NonNull String message) {
        Log.w(tag, message);
    }

    public static void e(@NonNull String message) {
        Log.e(TAG, message);
    }

    public static void e(@NonNull String tag, @NonNull String message) {
        Log.e(tag, message);
    }
}
