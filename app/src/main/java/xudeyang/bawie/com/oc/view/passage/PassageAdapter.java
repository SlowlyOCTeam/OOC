package xudeyang.bawie.com.oc.view.passage;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import xudeyang.bawie.com.oc.R;
import xudeyang.bawie.com.oc.utils.GlideCircleTransform;

/**
 * Created by 怪胎 on 2018.6.11.
 */

public class PassageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<PassageBean.DataBean> list;
    private Context context;
    private boolean ao = false;
    public PassageAdapter(List<PassageBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.passage_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final MyViewHolder my = (MyViewHolder) holder;
        Glide.with(context)
                .load(list.get(position).getUser().getIcon())
                .placeholder(R.drawable.ic_launcher_background)
                .transform(new GlideCircleTransform(context))
                .into(my.img_01);


        my.tv_name.setText(list.get(position).getUser().getNickname());
        my.tv_time.setText(list.get(position).getCreateTime());
        my.tv_title.setText(list.get(position).getContent());
        //动画
        my.ll_b.setVisibility(View.GONE);
        my.ll_c.setVisibility(View.GONE);
        my.ll_d.setVisibility(View.GONE);

        my.img_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my.img_a.setSelected(!my.img_a.isSelected());
                setAnimate2(my.img_a,1000);
                if (!ao){
                    setAnimate0(my.ll_b,400,0,-100);
                    // setAnimate2(my.img_b,1000);
                    setAnimate4(my.ll_b,400);

                    setAnimate0(my.ll_c,500,0,-200);
                    // setAnimate2(my.img_b,1000);
                    setAnimate4(my.ll_c,500);

                    setAnimate0(my.ll_d,600,0,-300);
                    // setAnimate2(my.img_b,1000);
                    setAnimate4(my.ll_d,600);
                    my.ll_b.setVisibility(View.VISIBLE);
                    my.ll_c.setVisibility(View.VISIBLE);
                    my.ll_d.setVisibility(View.VISIBLE);
                    my.ll_d.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(context,"敬请期待",Toast.LENGTH_SHORT).show();
                          //  Toast.makeText(context,"亲，已屏蔽",Toast.LENGTH_SHORT).show();
                        }
                    });
                    my.img_b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            my.img_b.setSelected(!my.img_b.isSelected());

                        }
                    });

                    my.ll_c.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(context,"敬请期待",Toast.LENGTH_SHORT).show();
                        }
                    });
                    my.ll_b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                          //  Toast.makeText(context,"敬请期待",Toast.LENGTH_SHORT).show();
                        }
                    });

                    ao = true;
                }else{
                    setAnimate0(my.ll_b,400,-100,0);
                    // setAnimate2(my.img_b,1000);
                    setAnimate3(my.ll_b,400);

                    setAnimate0(my.ll_c,500,-200,0);
                    // setAnimate2(my.img_b,1000);
                    setAnimate3(my.ll_c,500);

                    setAnimate0(my.ll_d,600,-300,0);
                    // setAnimate2(my.img_b,1000);
                    setAnimate3(my.ll_d,400);
                  /*  my.ll_b.setVisibility(View.GONE);
                    my.ll_c.setVisibility(View.GONE);
                    my.ll_d.setVisibility(View.GONE);*/
                    ao = false;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if (list.size()!=0){
            return list.size();
        }
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_01;
        private TextView tv_name;
        private TextView tv_time;
        private TextView tv_title;
        private LinearLayout ll_b;
        private LinearLayout ll_c;
        private LinearLayout ll_d;
        private ImageView img_a;
        private ImageView img_b;



        public MyViewHolder(View itemView) {
            super(itemView);
            img_01 = itemView.findViewById(R.id.img_01);
            tv_name = itemView.findViewById(R.id.hot_item_name);
            tv_time = itemView.findViewById(R.id.hot_item_time);
            tv_title = itemView.findViewById(R.id.passage_item_tv);
            ll_b = itemView.findViewById(R.id.ll_b);
            ll_c = itemView.findViewById(R.id.ll_c);
            ll_d = itemView.findViewById(R.id.ll_d);
            img_a = itemView.findViewById(R.id.img_a);
            img_b = itemView.findViewById(R.id.img_b);
        }
    }

    //平移
    private void setAnimate1(ImageView iv, int i, int a, int b) {
//      imageView中凡是有get，set方法的属性，都可以通过属性动画操作
//      创建属性动画对象，并设置移动的方向和偏移量
//      translationX是imageview的平移属性
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv, "translationX", a, b);
//      设置移动时间
        objectAnimator.setDuration(i);
//      开始动画
        objectAnimator.start();
    }
    //平移
    private void setAnimate0(LinearLayout iv, int i, int a, int b) {
//      imageView中凡是有get，set方法的属性，都可以通过属性动画操作
//      创建属性动画对象，并设置移动的方向和偏移量
//      translationX是imageview的平移属性
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv, "translationX", a, b);
//      设置移动时间
        objectAnimator.setDuration(i);
//      开始动画
        objectAnimator.start();
    }

    //旋转
    private void setAnimate2(ImageView iv, int i) {
//      创建属性动画对象，并设置移动的方向和偏移量
//      rotation是imageView的旋转属性
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv, "rotation", 0f, 180f);
//      设置移动时间
        objectAnimator.setDuration(i);
//      开始动画
        objectAnimator.start();
    }

    //渐变
    private void setAnimate3(LinearLayout iv, int i) {
//      创建属性动画对象，并设置移动的方向和偏移量
//      rotation是imageView的旋转属性
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv, "alpha", 1f, 0f);
//      设置移动时间
        objectAnimator.setDuration(1000);
//      开始动画
        objectAnimator.start();
    }
    //渐变
    private void setAnimate4(LinearLayout iv, int i) {
//      创建属性动画对象，并设置移动的方向和偏移量
//      rotation是imageView的旋转属性
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv, "alpha", 0f, 1f);
//      设置移动时间
        objectAnimator.setDuration(1000);
//      开始动画
        objectAnimator.start();
    }
}
