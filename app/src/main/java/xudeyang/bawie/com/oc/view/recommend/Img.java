package xudeyang.bawie.com.oc.view.recommend;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

public class Img extends ImageLoader {
    @Override  
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide加载图片简单用法  
        Glide.with(context).load(path).into(imageView);
    }  
}