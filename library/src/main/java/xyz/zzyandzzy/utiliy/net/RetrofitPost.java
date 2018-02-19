package xyz.zzyandzzy.utiliy.net;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by zzyandzzy on 2017/10/9.
 */

public interface RetrofitPost {
    @FormUrlEncoded
    @POST
    Observable<ResponseBody> doPostForUrl(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> doPostForUrlAddMap(@Url String url, @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> doPostForPath(@Url String path, @FieldMap Map<String, Object> params);

    @POST
    Observable<ResponseBody> doPostForPathWithJson(@Url String path, @Body RequestBody body);
}
