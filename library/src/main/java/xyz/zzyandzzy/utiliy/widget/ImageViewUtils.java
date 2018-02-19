package xyz.zzyandzzy.utiliy.widget;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;
import xyz.zzyandzzy.utiliy.log.LogUtils;
import xyz.zzyandzzy.utiliy.net.RetrofitHttpUtils;

public class ImageViewUtils {
    /**
     * @param imageView      imageView
     * @param url            图片地址
     * @param errDrawableRes 错误的drawable
     */
    @SuppressLint("CheckResult")
    public static void setImageBitmap(final ImageView imageView, String url,
                                      @DrawableRes final int errDrawableRes) {
        RetrofitHttpUtils.staticDoGetUrl(url)
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody body) throws Exception {
                        byte[] bytes = body.bytes();
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        imageView.setImageBitmap(bitmap);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.d(throwable.getMessage());
                        if (errDrawableRes != -1) {
                            imageView.setImageResource(errDrawableRes);
                        }
                    }
                });
    }

    /**
     * @param imageView imageView
     * @param url       图片地址
     */
    public static void setImageBitmap(final ImageView imageView, String url) {
        setImageBitmap(imageView, url, -1);
    }
}
