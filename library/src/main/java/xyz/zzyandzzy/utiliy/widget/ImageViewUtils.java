package xyz.zzyandzzy.utiliy.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;
import xyz.zzyandzzy.utiliy.net.RetrofitHttpUtils;

public class ImageViewUtils {
    /**
     * @param imageView image
     * @param url       子url
     */
    public static void setImageBitmap(final ImageView imageView, String url) {
        RetrofitHttpUtils.staticDoGetUrl(url)
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody body) throws Exception {
                        byte[] bytes = body.bytes();
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        imageView.setImageBitmap(bitmap);
                    }
                });
    }
}
