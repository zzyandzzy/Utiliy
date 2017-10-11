package xyz.zzyandzzy.utiliy.net;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


public interface RetrofitGet {
    @GET
    Observable<ResponseBody> doGetForUrl(@Url String url);

    @GET("{path}")
    Observable<ResponseBody> doGetForPath(@Path("path") String path);

    @GET("{path}")
    Observable<ResponseBody> doGetForPathAddQuery(@Path("path") String path, @QueryMap Map<String, String> params);
}