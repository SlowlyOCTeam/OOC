package xudeyang.bawie.com.oc.utils;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import xudeyang.bawie.com.oc.R;

/**
 * author:Created by WangZhiQiang on 2018/6/9.
 */
public class TitleBar extends LinearLayout {

    private final Context context;
    private View inflate;
    private View viewById;
    private TextView texttitlebar;
    public TitleBar(Context context) {
        this(context,null);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        inflate = View.inflate(context, R.layout.titlebar, this);
        viewById = inflate.findViewById(R.id.img_titlebar);
        texttitlebar = inflate.findViewById(R.id.text_titlebar);
    }
    /**
     * 返回的方法
    **/
     public  void setBack(final AppCompatActivity aa){
         viewById.setOnClickListener(new OnClickListener() {
             @Override
             public void onClick(View v) {
                 aa.finish();
             }
         });
     }
    /**
     * 功能的name
     **/
    public TextView getText(){

        return texttitlebar;
    }
}
