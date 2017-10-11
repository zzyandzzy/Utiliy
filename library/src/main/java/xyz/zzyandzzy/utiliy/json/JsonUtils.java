package xyz.zzyandzzy.utiliy.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.annotations.NonNull;

/**
 * Created by zzyandzzy on 2017/10/10.
 */

public class JsonUtils {

    /**
     * @param json     json
     * @param classOfT class
     * @return T
     */
    public static <T> T getObjectByJson(@NonNull String json, Class<T> classOfT) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, classOfT);
    }

}
