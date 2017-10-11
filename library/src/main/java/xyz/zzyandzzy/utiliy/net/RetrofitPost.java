package xyz.zzyandzzy.utiliy.net;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by zzyandzzy on 2017/10/9.
 */

public interface RetrofitPost {
    @FormUrlEncoded
    @POST("{path}")
    Observable<ResponseBody> doPostPath(@Path("path") String path, @FieldMap Map<String, String> params);
}
