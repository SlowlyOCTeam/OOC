package xudeyang.bawie.com.oc.view.recommend.hot.hotadapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import xudeyang.bawie.com.oc.R;
import xudeyang.bawie.com.oc.utils.GlideCircleTransform;
import xudeyang.bawie.com.oc.view.recommend.hot.hotbean.RecHotBean;

/**
 * Created by 怪胎 on 2018.6.9.
 */

public class HotMyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private PopupWindow popupWindow;
    private Context context;
    private List<RecHotBean.DataBean> list;
    private boolean bo = true;
    private boolean ao = false;
    private boolean co = false;
    private boolean oo = false;
    public HotMyAdapter(Context context, List<RecHotBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rem_hot_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final MyViewHolder my = (MyViewHolder) holder;
        Glide.with(context)
                .load(list.get(position).getCover())
                .placeholder(R.drawable.ic_launcher_background)
                .transform(new GlideCircleTransform(context))
                .into(my.touxian);
        my.time.setText(list.get(position).getCreateTime());
        if (list.get(position).getWorkDesc()==null||list.get(position).getWorkDesc()==""){
            my.name.setText("天蝎喝牛奶");
        }else {
            my.name.setText(list.get(position).getWorkDesc());
        }
        my.title.setText(list.get(position).getUser().getNickname());
        Glide.with(context)
                .load(list.get(position).getUser().getIcon())
                .into(my.shipin);
        my.pl1.setText(list.get(position).getComments().get(0).getNickname()+":");
        my.pl01.setText(list.get(position).getComments().get(1).getContent());
        my.pl2.setText(list.get(position).getComments().get(0).getNickname()+":");
        my.pl02.setText(list.get(position).getComments().get(1).getContent());
        my.a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my.a1.setSelected(!my.a1.isSelected());
                String s = my.tv_01.getText().toString();
                if (!co){
                    int i = Integer.parseInt(s);
                    my.tv_01.setText(i+1+"");
                    co = true;
                }else {
                    int j = Integer.parseInt(s);
                    my.tv_01.setText(j-1+"");
                    co = false;
                }

            }
        });
        my.a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my.a2.setSelected(!my.a2.isSelected());
                String s = my.tv_02.getText().toString();
                if (!oo){
                    int i = Integer.parseInt(s);
                    my.tv_02.setText(i+1+"");
                    oo = true;
                }else {
                    int j = Integer.parseInt(s);
                    my.tv_02.setText(j-1+"");
                    oo = false;
                }
            }
        });
        //显示   popwindows
        my.a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow == null) {
                    LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = layoutInflater.inflate(R.layout.hot_pop_item, null);
                    TextView textView = view.findViewById(R.id.hot_pop_tv);
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupWindow.dismiss();
                        }
                    });
                    // 创建一个PopuWidow对象
                    WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
                    popupWindow = new PopupWindow(view, windowManager.getDefaultDisplay().getWidth(), 550);
                }
                // 使其聚集
                popupWindow.setFocusable(true);
                // 设置允许在外点击消失
                popupWindow.setOutsideTouchable(true);

                // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                // 显示的位置为:屏幕的宽度的一半-PopupWindow的高度的一半
             //   int xPos = windowManager.getDefaultDisplay().getWidth() - popupWindow.getWidth();
              //  Log.i("coder", "xPos:" + xPos);
                popupWindow.showAsDropDown(my.hot_zong, 0, -550);
               // popupWindow.showAtLocation(my.a3, Gravity.LEFT, 0, 0);
            }
        });

        my.a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"敬请期待",Toast.LENGTH_SHORT).show();
            }
        });



        //显示隐藏侧面
        my.shipin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bo){
                    my.lin.setVisibility(View.GONE);
                    bo = false;
                }else {
                    my.lin.setVisibility(View.VISIBLE);
                    bo = true;
                }
            }
        });



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
                    setAnimate0(my.ll_b,400,0,-80);
                    // setAnimate2(my.img_b,1000);
                    setAnimate4(my.ll_b,400);

                    setAnimate0(my.ll_c,500,0,-160);
                    // setAnimate2(my.img_b,1000);
                    setAnimate4(my.ll_c,500);

                    setAnimate0(my.ll_d,600,0,-240);
                    // setAnimate2(my.img_b,1000);
                    setAnimate4(my.ll_d,600);
                    my.ll_b.setVisibility(View.VISIBLE);
                    my.ll_c.setVisibility(View.VISIBLE);
                    my.ll_d.setVisibility(View.VISIBLE);
                    my.ll_d.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(context,"亲，已屏蔽",Toast.LENGTH_SHORT).show();
                        }
                    });
                    my.ll_c.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(context,"亲，复制失败",Toast.LENGTH_SHORT).show();
                        }
                    });
                    my.ll_b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(context,"亲，不可以举报",Toast.LENGTH_SHORT).show();
                        }
                    });


                    ao = true;
                }else{
                    setAnimate0(my.ll_b,600,-240,0);
                    // setAnimate2(my.img_b,1000);
                    setAnimate3(my.ll_b,400);

                    setAnimate0(my.ll_c,500,-160,0);
                    // setAnimate2(my.img_b,1000);
                    setAnimate3(my.ll_c,500);

                    setAnimate0(my.ll_d,400,-80,0);
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
        if (list!=null){
            return list.size();
        }
            return 0;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView touxian;
        private ImageView shipin;
        private TextView name;
        private TextView time;
        private TextView title;
        private TextView pl1;
        private TextView pl01;
        private TextView pl2;
        private TextView pl02;
        private ImageView a1;
        private ImageView a2;
        private ImageView a3;
        private ImageView a4;
        private LinearLayout lin;
        private LinearLayout ll_b;
        private LinearLayout ll_c;
        private LinearLayout ll_d;
        private ImageView img_a;
        private ImageView img_b;
        private ImageView img_c;
        private ImageView img_d;
        private TextView tv_01;
        private TextView tv_02;
        private LinearLayout hot_zong;
        public MyViewHolder(View itemView) {
            super(itemView);
            hot_zong = itemView.findViewById(R.id.hot_zong);
            touxian = itemView.findViewById(R.id.img_01);
            shipin = itemView.findViewById(R.id.img_02);
            name = itemView.findViewById(R.id.hot_item_name);
            time = itemView.findViewById(R.id.hot_item_time);
            title = itemView.findViewById(R.id.hot_item_title);
            pl1 = itemView.findViewById(R.id.hot_item_pl1);
            pl01 = itemView.findViewById(R.id.hot_item_pl01);
            pl2 = itemView.findViewById(R.id.hot_item_pl2);
            pl02 = itemView.findViewById(R.id.hot_item_pl02);
            a1 = itemView.findViewById(R.id.hot_item_a1);
            a2 = itemView.findViewById(R.id.hot_item_a2);
            a3 = itemView.findViewById(R.id.hot_item_a3);
            a4 = itemView.findViewById(R.id.hot_item_a4);
            lin = itemView.findViewById(R.id.linearlayout_cemian);
            ll_b = itemView.findViewById(R.id.ll_b);
            ll_c = itemView.findViewById(R.id.ll_c);
            ll_d = itemView.findViewById(R.id.ll_d);
            img_a = itemView.findViewById(R.id.img_a);
            img_b = itemView.findViewById(R.id.img_b);
            img_c = itemView.findViewById(R.id.img_c);
            img_d = itemView.findViewById(R.id.img_d);
            tv_01 = itemView.findViewById(R.id.hot_item_num01);
            tv_02 = itemView.findViewById(R.id.hot_item_num02);
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
