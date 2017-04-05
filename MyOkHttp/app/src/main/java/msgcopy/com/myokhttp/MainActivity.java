package msgcopy.com.myokhttp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import msgcopy.com.myokhttp.callbacks.BitmapCallback;
import msgcopy.com.myokhttp.callbacks.StringCallback;
import msgcopy.com.myokhttp.utils.LogUtils;
import msgcopy.com.myokhttp.utils.OkHttpUtils;
import okhttp3.Call;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyMainActivity";

    private TextView mTv;
    private ImageView mImageView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv = (TextView) findViewById(R.id.id_textview);
        mImageView = (ImageView) findViewById(R.id.id_imageview);

    }

    public void postString(View view) {

        String url = "http://cloud1.kaoke.me/iapi/user/register/auto/?channel_id=A1G1Z00110CjcA002A001A001A0010000T";

        OkHttpUtils
                .post()
                .url(url)
                .addParams("type", "auto")
                .addParams("reg_ver", "1")
                .addParams("device", "00000000")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mTv.setText(e.getMessage());
                        LogUtils.i("onError",""+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        mTv.setText(response);
                        LogUtils.i("onResponse",""+response);
                    }
                });

    }

    public void getImage(View view) {

        String url = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3630446877,1647320500&fm=11&gp=0.jpg";

        OkHttpUtils
                .get()
                .url(url)
                .tag(this)
                .build()
                .connTimeOut(20000)
                .readTimeOut(20000)
                .writeTimeOut(20000)
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.i("onError",""+e.getMessage());
                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {
                        mImageView.setImageBitmap(response);
                    }
                });
    }

    public void getString(View view) {

        String url = "http://api.map.baidu.com/telematics/v3/weather?location=%s&output=json&ak=%s";
        OkHttpUtils
                .get()
                .url(url)
                .tag(this)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        mTv.setText(e.getMessage());
                        LogUtils.i("onError",""+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        mTv.setText(response);
                        LogUtils.i("onResponse",""+response);
                    }
                });
    }
    public void getHtml(View view){

    }

}













