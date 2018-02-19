package xyz.zzyandzzy.utiliy;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;
import xyz.zzyandzzy.utiliy.log.LogUtils;
import xyz.zzyandzzy.utiliy.net.RetrofitHttpUtils;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    public static final String POST_URL = "http://www.zzyandzzy.xyz:7290/";

    private RetrofitHttpUtils retrofitHttpUtils;

    @Before
    public void init() {
        retrofitHttpUtils = new RetrofitHttpUtils(POST_URL);
    }

    @Test
    public void doStaticPostTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("words", "[]");
        retrofitHttpUtils.doPostPathWithJson(map)
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        System.out.println(responseBody.string());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println(throwable.getMessage());
                    }
                });
    }
}