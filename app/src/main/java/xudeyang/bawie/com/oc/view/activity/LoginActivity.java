package xudeyang.bawie.com.oc.view.activity;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

import xudeyang.bawie.com.oc.R;
import xudeyang.bawie.com.oc.utils.TitleBar;
import xudeyang.bawie.com.oc.view.base.BaseActivity;

public class LoginActivity extends BaseActivity {


    TitleBar titlebarLoginlogin;
    private TextView text;

    @Override
    public void initView() {
        setContentView(R.layout.activity_login);

        ActivityCompat.requestPermissions(LoginActivity.this, new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.READ_SMS,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    @Override
    public void initHttp() {
         titlebarLoginlogin = findViewById(R.id.titlebar_loginlogin);
         titlebarLoginlogin.setBack(this);
         text = titlebarLoginlogin.getText();
         text.setVisibility(View.GONE);

    }

    @Override
    public void initData() {

    }


}
