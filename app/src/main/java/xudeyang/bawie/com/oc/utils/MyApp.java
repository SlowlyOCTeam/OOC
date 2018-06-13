package xudeyang.bawie.com.oc.utils;

import android.app.Application;

import com.orhanobut.hawk.Hawk;
import com.zhy.changeskin.SkinManager;

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
        SkinManager.getInstance().init(this);
    }

}
