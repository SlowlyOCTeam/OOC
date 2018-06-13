package xudeyang.bawie.com.oc.view.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import xudeyang.bawie.com.oc.R;
import xudeyang.bawie.com.oc.view.base.BaseActivity;
import xudeyang.bawie.com.oc.view.fragment.PassageFM;
import xudeyang.bawie.com.oc.view.fragment.PhotoFM;
import xudeyang.bawie.com.oc.view.fragment.RecommendFM;
import xudeyang.bawie.com.oc.view.fragment.VideoFM;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener{

    BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;
    private TextBadgeItem textBadgeItem;
    private CoordinatorLayout right;
    private NavigationView left;
    private RecommendFM recommendFM;
    private VideoFM videoFM;
    private PassageFM passageFM;
    private PhotoFM photoFM;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        right = (CoordinatorLayout) findViewById(R.id.right);
        left = (NavigationView) findViewById(R.id.nav_view);
        bottomNavigationBar=findViewById(R.id.bottomnavigation);
        bottomNavigationBar
                .setTabSelectedListener(this)
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                /**
                 *  setMode() 内的参数有三种模式类型：
                 *  MODE_DEFAULT 自动模式：导航栏Item的个数<=3 用 MODE_FIXED 模式，否则用 MODE_SHIFTING 模式
                 *  MODE_FIXED 固定模式：未选中的Item显示文字，无切换动画效果。
                 *  MODE_SHIFTING 切换模式：未选中的Item不显示文字，选中的显示文字，有切换动画效果。
                 */

                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                /**
                 *  setBackgroundStyle() 内的参数有三种样式
                 *  BACKGROUND_STYLE_DEFAULT: 默认样式 如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC
                 *                                    如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
                 *  BACKGROUND_STYLE_STATIC: 静态样式 点击无波纹效果
                 *  BACKGROUND_STYLE_RIPPLE: 波纹样式 点击有波纹效果
                 */

                .setActiveColor("#ffffff") //选中颜色
                .setInActiveColor("#CACAC2")//未选中颜色
                .setBarBackgroundColor("#03A9F4")
        ;//导航栏背景色
        //设置被选中时隐藏角标
        //设置被选中时隐藏角标
        textBadgeItem = new TextBadgeItem().setHideOnSelect(true) //设置被选中时隐藏角标
                .setBackgroundColor(Color.RED)
                .setText("3");
        BottomNavigationItem item = new BottomNavigationItem(R.drawable.video, "视频").setBadgeItem(textBadgeItem);
        /** 添加导航按钮 */
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.tui, "推荐"))
                .addItem(new BottomNavigationItem(R.drawable.duanzi, "段子"))
                .addItem(item)
                .addItem(new BottomNavigationItem(R.drawable.photo, "趣图"))
                .initialise(); //initialise 一定要放在 所有设置的最后一项
    }

    @Override
    public void initHttp() {

    }

    @Override
    public void initData() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
                right.layout(left.getRight(), 0, left.getRight() + display.getWidth(), display.getHeight());
            }
            @Override
            public void onDrawerOpened(View drawerView) {

            }
            @Override
            public void onDrawerClosed(View drawerView) {

            }
            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        recommendFM = RecommendFM.newInstance("推荐", "");
        passageFM = PassageFM.newInstance("段子", "");
        videoFM = VideoFM.newInstance("视频", "");
        photoFM = PhotoFM.newInstance("趣图", "");
        smartFragmentReplace(R.id.fl,recommendFM);
    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                smartFragmentReplace(R.id.fl,recommendFM);
                break;
            case 1:
                smartFragmentReplace(R.id.fl,passageFM);
                break;
            case 2:
                smartFragmentReplace(R.id.fl,videoFM);
                textBadgeItem.setHideOnSelect(false);
                break;
            case 3:
                smartFragmentReplace(R.id.fl,photoFM);
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
