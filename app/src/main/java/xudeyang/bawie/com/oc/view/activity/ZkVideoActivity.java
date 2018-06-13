package xudeyang.bawie.com.oc.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.yixia.camera.MediaRecorderBase;
import com.yixia.camera.util.Log;
import com.zhaoshuang.weixinrecorded.MyVideoView;
import com.zhaoshuang.weixinrecorded.RecordedActivity;

import xudeyang.bawie.com.oc.R;
import xudeyang.bawie.com.oc.view.base.BaseActivity;

public class ZkVideoActivity extends AppCompatActivity {
    private RelativeLayout picturere;
    private RelativeLayout videore;
    private MyVideoView vedio_play;
    private RelativeLayout rl_show;
    private ImageView vedio_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zk_video);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        picturere = findViewById(R.id.picture_relative);
        videore = findViewById(R.id.video_relative);
        vedio_play = findViewById(R.id.vedio_play);
        rl_show = findViewById(R.id.rl_show);
        vedio_photo = findViewById(R.id.vedio_photo);


        //直接跳转到拍摄界面
        Intent intent = new Intent(this, RecordedActivity.class);
        startActivityForResult(intent, 0);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){

            String imagePath = data.getStringExtra("imagePath");
            String videoPath = data.getStringExtra("videoPath");
            if(!TextUtils.isEmpty(imagePath)){
                picturere.setVisibility(View.VISIBLE);
                videore.setVisibility(View.GONE);


                Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
                vedio_photo.setImageBitmap(bitmap);
            }else if(!TextUtils.isEmpty(videoPath)){
                picturere.setVisibility(View.GONE);
                videore.setVisibility(View.VISIBLE);

                vedio_play.setVideoPath(videoPath);
                vedio_play.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        vedio_play.setLooping(true);
                        vedio_play.start();

                        float widthF = vedio_play.getVideoWidth() * 1f / MediaRecorderBase.VIDEO_HEIGHT;
                        float heightF = vedio_play.getVideoHeight() * 1f / MediaRecorderBase.VIDEO_WIDTH;
                        ViewGroup.LayoutParams layoutParams = vedio_play.getLayoutParams();
                        layoutParams.width = (int) (rl_show.getWidth() * widthF);
                        layoutParams.height = (int) (rl_show.getHeight() * heightF);
                        vedio_play.setLayoutParams(layoutParams);
                    }
                });


            }

        }

    }


}
