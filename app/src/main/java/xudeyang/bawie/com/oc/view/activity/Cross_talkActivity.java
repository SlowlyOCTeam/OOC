package xudeyang.bawie.com.oc.view.activity;

import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.guoqi.actionsheet.ActionSheet;
import com.zhaoshuang.weixinrecorded.RecordedActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import xudeyang.bawie.com.oc.R;
import xudeyang.bawie.com.oc.utils.zkutil.Imageinterface;
import xudeyang.bawie.com.oc.utils.zkutil.ImgUtil;
import xudeyang.bawie.com.oc.utils.zkutil.ZkStreaming;

public class Cross_talkActivity extends AppCompatActivity  implements  ActionSheet.OnActionSheetSelected{
    private static final int CHOOSE_PHOTO=0;
    private ZkStreaming liushilayout;
    private ImageView jiajias;
    private ImageView creation_joke_back;
    private List<ImageView>  list=new ArrayList<>();
    private Imageinterface imageinterface;
    private TextView creation_joke_publish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_talk);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        imageinterface = new BrowseActivity();

        liushilayout = findViewById(R.id.liushilayout);
        jiajias = findViewById(R.id.jiajias);
        creation_joke_back = findViewById(R.id.creation_joke_back);
        creation_joke_publish = findViewById(R.id.creation_joke_publish);


        //点击发表
        creation_joke_publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        //点击弹出拍照 相册
        jiajias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionSheet.showSheet(Cross_talkActivity.this, Cross_talkActivity.this, null);
            }
        });

        //点击浏览图片
       /* liushilayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                for(int i=0;i<liushilayout.getChildCount();i++){
                    ImageView view= (ImageView) liushilayout.getChildAt(i);
                    list.add(view);
                }
         Intent intent=new Intent(Cross_talkActivity.this,BrowseActivity.class);
                *//*Bundle bundle=new Bundle();
                bundle.putSerializable("f", (Serializable) list);
                intent.putExtra("io",bundle);*//*
                startActivity(intent);

                //接口回调方式
             //   imageinterface.chuan(list);

            }
        });*/



        //点击返回按钮
        creation_joke_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //开启子线程模仿点击返回键
                new Thread () {
                    public void run () {
                        try {
                            Instrumentation inst= new Instrumentation();
                            inst.sendKeyDownUpSync(KeyEvent. KEYCODE_BACK);
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }

    @Override
    public void onClick(int whichButton) {
        switch (whichButton) {
            case ActionSheet.CHOOSE_PICTURE:
                //相册
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                startActivityForResult(intent, CHOOSE_PHOTO);
                break;
            case ActionSheet.TAKE_PICTURE:
                //直接跳转到拍摄界面
                Intent intent2 = new Intent(this, RecordedActivity.class);
                startActivityForResult(intent2, 222);

                break;
            case ActionSheet.CANCEL:
                //取消
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CHOOSE_PHOTO:
                if (resultCode == RESULT_OK) {
                    Bitmap bitmap = null;
                    //判断手机系统版本号
                    if (Build.VERSION.SDK_INT >= 19) {
                        //4.4及以上系统使用这个方法处理图片
                        bitmap = ImgUtil.handleImageOnKitKat(this, data);        //ImgUtil是自己实现的一个工具类
                    } else {
                        //4.4以下系统使用这个方法处理图片
                        bitmap = ImgUtil.handleImageBeforeKitKat(this, data);
                    }



                    //动态添加imageview
                    ImageView imageView=new ImageView(Cross_talkActivity.this);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(300,300));
                    imageView.setPadding(5,5,5,5);
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    liushilayout.addView(imageView,0);


                    //得到控件数
                    int count=liushilayout.getChildCount();

                    if(count==7){
                        jiajias.setVisibility(View.GONE);
                    }


                }
                break;
            default:
                break;
        }
        if(requestCode==222){

            String imagePath = data.getStringExtra("imagePath");
            String videoPath = data.getStringExtra("videoPath");
            if(!TextUtils.isEmpty(imagePath)){
                Bitmap bitmap2 = BitmapFactory.decodeFile(imagePath);
                //动态添加imageview
                ImageView imageView=new ImageView(Cross_talkActivity.this);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(300,300));
                imageView.setPadding(5,5,5,5);
                imageView.setImageBitmap(bitmap2);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                liushilayout.addView(imageView,0);


                //得到控件数
                int count=liushilayout.getChildCount();

                if(count==7){
                    jiajias.setVisibility(View.GONE);
                }

            }else if(!TextUtils.isEmpty(videoPath)){
                Toast.makeText(Cross_talkActivity.this,"您只能编辑图片！", Toast.LENGTH_LONG).show();
            }
        }


    }
}
