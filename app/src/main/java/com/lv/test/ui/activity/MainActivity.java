package com.lv.test.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.widget.Toast;

import com.lv.test.App;
import com.lv.test.R;
import com.lv.test.ui.IView.IUserView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IUserView {

    @Bind(R.id.name)
    AppCompatEditText name;
    @Bind(R.id.pwd)
    AppCompatEditText pwd;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressDialog=new ProgressDialog(this);
        App.getApp().setBaseView(this);
        RequestParams params = new RequestParams("http://gdown.baidu.com/data/wisegame/6e2cd3e0f2055711/QQ_350.apk");
        params.setSaveFilePath(Environment.getExternalStorageDirectory().getAbsolutePath()+"/duminj.apk");
        x.http().get(params, new Callback.ProgressCallback<File>() {
            @Override
            public void onWaiting() {

            }
            @Override
            public void onStarted() {

            }
            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                    System.out.println(current/total);
            }
            @Override
            public void onSuccess(File result) {
                Log.d("MainActivity", result.getPath());
                LocalBroadcastManager manager = LocalBroadcastManager.getInstance(MainActivity.this);
                manager.sendBroadcast(new Intent("test"));
                Toast.makeText(MainActivity.this, "onSuccess"+result.getPath(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(MainActivity.this, "onError", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(CancelledException cex) {
                Toast.makeText(MainActivity.this, "onCancelled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinished() {
                Toast.makeText(MainActivity.this, "onFinished", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public String getUserName() {
        return name.getText().toString();
    }

    @Override
    public String getPwd() {
        return pwd.getText().toString();
    }

    @Override
    public void showLoadingView() {
        progressDialog.show();
    }

    @Override
    public void hideLoadingView() {
        progressDialog.dismiss();
    }

    @Override
    public void toastError(String message) {

    }

    public void showToast(@NonNull String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void notifyDialog(@NonNull String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Material Design Dialog");
        builder.setMessage(message);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", null);
        builder.show();
    }


    @OnClick(R.id.login)
    public void onClick() {
    }
}
