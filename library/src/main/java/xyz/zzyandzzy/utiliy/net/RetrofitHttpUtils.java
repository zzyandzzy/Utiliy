package xyz.zzyandzzy.utiliy.net;

import org.json.JSONObject;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHttpUtils {
    // 超时
    private static final long TIMEOUT = 10;
    private static final String BASE_URL = "http://www.zzyandzzy.xyz/";

    private static OkHttpClient client = null;
    private static Retrofit retrofit = null;

    /**
     * @param baseUrl 子url
     */
    public RetrofitHttpUtils(@NonNull String baseUrl) {
        if (retrofit == null) {
            client = getInstanceOkHttpClient();
            retrofit = getInstanceRetrofit(baseUrl);
        }
    }

    /**
     * @return OkHttpClient
     */
    private static OkHttpClient getInstanceOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 静态Retrofit
     *
     * @param baseUrl 子url
     * @return Retrofit
     */
    private static Retrofit getInstanceRetrofit(@NonNull String baseUrl) {
        if (client == null){
            client = getInstanceOkHttpClient();
        }
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(client)
                .build();
    }

    /**
     * @param baseUrl 子url
     * @return ResponseBody
     */
    public static Observable<ResponseBody> staticDoGetUrl(@NonNull String baseUrl) {
        if (retrofit == null){
            retrofit = getInstanceRetrofit(BASE_URL);
        }
        RetrofitGet retrofitGet = retrofit.create(RetrofitGet.class);
        return retrofitGet.doGetForUrl(baseUrl)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * @param baseUrl 子Url
     * @return JSONObject
     */
    public static Observable<JSONObject> staticDoGetUrlToJson(@NonNull String baseUrl) {
        return staticDoGetUrl(baseUrl).map(new Function<ResponseBody, JSONObject>() {
            @Override
            public JSONObject apply(ResponseBody body) throws Exception {
                String str = body.string();
                return new JSONObject(str);
            }
        });
    }

    /**
     * get
     * 结合了Retrofit框架
     *
     * @param path 路径
     * @return ResponseBody
     */
    public Observable<ResponseBody> doGetPath(@NonNull String path) {
        RetrofitGet retrofitGet = retrofit.create(RetrofitGet.class);
        return retrofitGet.doGetForPath(path)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * get
     * 结合了Retrofit框架
     *
     * @param path 路径
     * @return JSONObject
     */
    public Observable<JSONObject> doGetPathToJson(@NonNull String path) {
        return doGetPath(path).map(new Function<ResponseBody, JSONObject>() {
            @Override
            public JSONObject apply(ResponseBody body) throws Exception {
                String str = body.string();
                return new JSONObject(str);
            }
        });
    }

    /**
     * get
     * 结合了Retrofit框架
     *
     * @param path   路径
     * @param params Map
     * @return ResponseBody
     */
    public Observable<ResponseBody> doGetPath(@NonNull String path, @NonNull Map<String, String> params) {
        RetrofitGet retrofitGet = retrofit.create(RetrofitGet.class);
        return retrofitGet.doGetForPathAddQuery(path, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * get
     * 结合了Retrofit框架
     *
     * @param path   路径
     * @param params Map
     * @return JSONObject
     */
    public Observable<JSONObject> doGetPathToJson(@NonNull String path, @NonNull Map<String, String> params) {
        return doGetPath(path, params).map(new Function<ResponseBody, JSONObject>() {
            @Override
            public JSONObject apply(ResponseBody body) throws Exception {
                String str = body.string();
                return new JSONObject(str);
            }
        });
    }

    /**
     * post
     * 获取responseBody
     * 结合了Retrofit框架
     *
     * @param path   路径
     * @param params Map
     * @return ResponseBody
     */
    public Observable<ResponseBody> doPostPath(@NonNull String path, @NonNull Map<String, String> params) {
        RetrofitPost retrofitPost = retrofit.create(RetrofitPost.class);
        return retrofitPost.doPostPath(path, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * post
     * 获取responseBody
     * 结合了Retrofit框架
     *
     * @param path   路径
     * @param params Map
     * @return JSONObject
     */
    public Observable<JSONObject> doPostPathToJson(@NonNull String path, @NonNull Map<String, String> params) {
        return doPostPath(path, params).map(new Function<ResponseBody, JSONObject>() {
            @Override
            public JSONObject apply(ResponseBody body) throws Exception {
                String str = body.string();
                return new JSONObject(str);
            }
        });
    }
}
