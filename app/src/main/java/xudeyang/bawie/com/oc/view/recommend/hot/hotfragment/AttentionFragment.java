package xudeyang.bawie.com.oc.view.recommend.hot.hotfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import xudeyang.bawie.com.oc.R;
import xudeyang.bawie.com.oc.utils.RetrofitUtil;
import xudeyang.bawie.com.oc.view.recommend.hot.hotadapter.HotMyAdapter;
import xudeyang.bawie.com.oc.view.recommend.hot.hotbean.RecHotBean;

/**
 * Created by Carson_Ho on 16/7/22.
 */
public class AttentionFragment extends Fragment {
    private RecyclerView rlv;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.attention_fragment, container, false);
        //找组件
        findinfor();
        //网络请求
        intnight();
        return view;
    }

    private void intnight() {
        Flowable<RecHotBean> rechots = RetrofitUtil.getInstance().rechot("F8EB129296C90580807D0C6D9FD9B7F7", "1");
        rechots.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RecHotBean>() {
                    @Override
                    public void accept(RecHotBean recHotBean) throws Exception {
                        List<RecHotBean.DataBean> list = recHotBean.getData();
                        String msg = recHotBean.getMsg();
                        //Log.i("Hot",msg+"==========");
                        HotMyAdapter hotMyAdapter = new HotMyAdapter(getContext(), list);
                        rlv.setAdapter(hotMyAdapter);
                    }
                });
    }
    private void findinfor() {
        rlv = view.findViewById(R.id.hot_rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
