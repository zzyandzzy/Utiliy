package xyz.zzyandzzy.utiliy;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;
import xyz.zzyandzzy.utiliy.log.LogUtils;
import xyz.zzyandzzy.utiliy.net.RetrofitHttpUtils;
import xyz.zzyandzzy.utiliy.widget.ImageViewUtils;

public class MainActivity extends AppCompatActivity {
    public static final String GET_URL = "http://www.zzyandzzy.xyz/";
    public static final String POST_URL = "http://www.zzyandzzy.xyz:7290/";
    public static final String IMAGE_URL = "https://avatars1.githubusercontent.com/u/14029779?v=4&s=460";

    private TextView tv1;
    private ImageView iv1;

    private RetrofitHttpUtils retrofitHttpUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();
        getHttp();
        setImageBitmapFromUrl();
    }

    private void init() {
        retrofitHttpUtils = new RetrofitHttpUtils(POST_URL);
    }

    private void initView() {
        tv1 = findViewById(R.id.main_tv1);
        iv1 = findViewById(R.id.main_iv1);
    }

    @SuppressLint("CheckResult")
    private void getHttp() {
        RetrofitHttpUtils.staticDoGetUrl(GET_URL)
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody body) throws Exception {
                        tv1.setText(body.string());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.d(throwable.getMessage());
                    }
                });
        Map<String, Object> map = new HashMap<>();
        map.put("words", "哈哈");
        retrofitHttpUtils.doPostPathWithJson("/dt/get_urls", map)
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        LogUtils.d(responseBody.string());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.d(throwable.getMessage());
                    }
                });
    }

    private void setImageBitmapFromUrl() {
        ImageViewUtils.setImageBitmap(iv1, IMAGE_URL);
    }
}
