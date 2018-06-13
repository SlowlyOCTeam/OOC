package xudeyang.bawie.com.oc.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhy.changeskin.SkinManager;

import xudeyang.bawie.com.oc.R;
import xudeyang.bawie.com.oc.view.base.BaseActivity;

public class ZKCreationActivity extends BaseActivity {
    private ImageView video;
    private ImageView joke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zkcreation);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        video = findViewById(R.id.creation_video_click);
        joke = findViewById(R.id.creation_joke_click);

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击跳转到拍摄界面
                openActivity(ZkVideoActivity.class);
            }
        });

        joke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击跳转到编辑段子界面
                openActivity(Cross_talkActivity.class);
            }
        });
    }
    @Override
    public void initView() {

    }

    @Override
    public void initHttp() {

    }

    @Override
    public void initData() {

    }



}
