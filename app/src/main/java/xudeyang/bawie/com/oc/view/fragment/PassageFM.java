package xudeyang.bawie.com.oc.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import xudeyang.bawie.com.oc.R;
import xudeyang.bawie.com.oc.utils.RetrofitUtil;
import xudeyang.bawie.com.oc.view.activity.ZKCreationActivity;
import xudeyang.bawie.com.oc.view.passage.PassageAdapter;
import xudeyang.bawie.com.oc.view.passage.PassageBean;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 * Use the {@link PassageFM#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PassageFM extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View inflate;
    private RecyclerView rlv;

    public PassageFM() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PassageFM.
     */
    // TODO: Rename and change types and number of parameters
    public static PassageFM newInstance(String param1, String param2) {
        PassageFM fragment = new PassageFM();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_passage_fm, container, false);
        TextView textView = inflate.findViewById(R.id.container1);
        ImageView mycreation=inflate.findViewById(R.id.mycreation);
        textView.setText(mParam1);

        //找组件
        initto();
        //网络请求+适配器展示
        network();
        mycreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ZKCreationActivity.class);
                startActivity(intent);
            }
        });

        return inflate;
    }
    private void network() {
        Flowable<PassageBean> passageAdapterFlowable = RetrofitUtil.getInstance().passageZong("F8EB129296C90580807D0C6D9FD9B7F7", "1");
        passageAdapterFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PassageBean>() {
                    @Override
                    public void accept(PassageBean passageBean) throws Exception {
                        List<PassageBean.DataBean> data = passageBean.getData();
                        PassageAdapter passageAdapter = new PassageAdapter(data, getActivity());
                        rlv.setAdapter(passageAdapter);
                    }
                });
    }

    private void initto() {
        rlv = inflate.findViewById(R.id.passage_rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


}
