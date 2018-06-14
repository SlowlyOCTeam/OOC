package xudeyang.bawie.com.oc.view.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import xudeyang.bawie.com.oc.R;
import xudeyang.bawie.com.oc.view.base.BaseActivity;

public class UserActivity extends BaseActivity {

    @Override
    public void initView() {
        setContentView(R.layout.activity_user);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        Toast.makeText(this,name+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initHttp() {

    }

    @Override
    public void initData() {

    }
}
