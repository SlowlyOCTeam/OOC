package xudeyang.bawie.com.oc.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xudeyang.bawie.com.oc.R;
import xudeyang.bawie.com.oc.utils.zkutil.Imageinterface;

public class BrowseActivity extends AppCompatActivity implements Imageinterface {
    private List<View> datas=new ArrayList<View>();
    private List<ImageView> list;
    private ViewPager vp;

//主要问题是把集合传过来
    Handler  handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);



        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_browse);
        vp = findViewById(R.id.vp);
        //3.构造适配器(arrayAdapter,simpleadapter,baseAdapter)
        MyAdapter adapter=new MyAdapter();
        //4.给viewpager设置适配器
        vp.setAdapter(adapter);
    }

    //拿到集合
    @Override
    public void chuan(List<ImageView> list) {
     this.list=list;
   //  handler.sendEmptyMessage(0);
    }


    class MyAdapter extends PagerAdapter {

        //返回页面的数据
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        //返回视图与key是否相等
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0==arg1;
        }

        //装载页面
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //container:代表viewpager容器
            //position:0~2
            container.addView(list.get(position));

            //返回一个与当前页面相关联的key
            return list.get(position);
        }
        //销毁页面
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            //必须要注释或删掉
//			super.destroyItem(container, position, object);
            //进行移除视图
            container.removeView(datas.get(position));
        }

    }





}
