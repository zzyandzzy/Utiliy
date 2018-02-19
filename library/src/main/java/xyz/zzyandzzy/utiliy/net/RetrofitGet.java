package xyz.zzyandzzy.utiliy.net;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


public interface RetrofitGet {
    @GET
    Observable<ResponseBody> doGetForUrl(@Url String path);

    @GET
    Observable<ResponseBody> doGetForPathAddQuery(@Url String path,
                                                  @QueryMap Map<String, Object> params);
}