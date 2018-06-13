package xudeyang.bawie.com.oc.utils;

import android.app.Application;

import com.orhanobut.hawk.Hawk;

import skin.support.SkinCompatManager;
import skin.support.design.app.SkinMaterialViewInflater;

/**
 * Created by Mac on 2018/6/8.
 */

public class MyApp extends Application {
    public static final String MODEL = "model";
    public static final boolean DEFAULT_MODEL = false;

    public static final boolean NIGHT_MODEL = true;
    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
        //换皮肤
        SkinCompatManager.withoutActivity(this)                         // Basic Widget support
                .addInflater(new SkinMaterialViewInflater())            // material design 控件换肤初始化[可选]
                .setSkinStatusBarColorEnable(false)                     // Disable statusBarColor skin support，default true   [selectable]
               // .setSkinWindowBackgroundEnable(false)                   // Disable windowBackground skin support，default true [selectable]
                .loadSkin();
        //切换为默认皮肤
        try{
            if(!(boolean)Hawk.get(MODEL)){
                SkinCompatManager.getInstance().restoreDefaultTheme();
            }else{
                SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // load by suffix
            }
        }catch (Exception e){ // 默认加载默认模式
            SkinCompatManager.getInstance().restoreDefaultTheme();
        }
    }

}
