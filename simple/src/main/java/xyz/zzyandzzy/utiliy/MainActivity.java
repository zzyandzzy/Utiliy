package xyz.zzyandzzy.utiliy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;
import xyz.zzyandzzy.utiliy.net.RetrofitHttpUtils;
import xyz.zzyandzzy.utiliy.widget.ImageViewUtils;

public class MainActivity extends AppCompatActivity {
    public static final String GET_URL = "http://www.zzyandzzy.xyz/";
    public static final String IMAGE_URL = "https://avatars1.githubusercontent.com/u/14029779?v=4&s=460";

    private TextView tv1;
    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        getHttp();
        setImageBitmapFromUrl();
    }

    private void initView() {
        tv1 = findViewById(R.id.main_tv1);
        iv1 = findViewById(R.id.main_iv1);
    }

    private void getHttp() {
        RetrofitHttpUtils.staticDoGetUrl(GET_URL)
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody body) throws Exception {
                        tv1.setText(body.string());
                    }
                });
    }

    private void setImageBitmapFromUrl() {
        ImageViewUtils.setImageBitmap(iv1, IMAGE_URL);
    }
}
